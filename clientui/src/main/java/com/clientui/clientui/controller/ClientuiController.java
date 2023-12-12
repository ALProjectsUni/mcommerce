package com.clientui.clientui.controller;

import com.clientui.clientui.beans.ProductBean;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.clientui.clientui.proxies.MicroserviceProduitsProxy;

import java.util.List;

@Controller
public class ClientuiController {

    private final MicroserviceProduitsProxy produitsProxy;

    @Autowired
    public ClientuiController(MicroserviceProduitsProxy produitsProxy)
    {
        this.produitsProxy = produitsProxy;
    }

    @RequestMapping("/")
    public String   accueil(Model model)
    {
        List<ProductBean> produits = produitsProxy.listeDesProduits();
        model.addAttribute("produits", produits);
        return "Accueil";
    }

    @RequestMapping("/details-produit/{id}")
    public String ficheProduit(@PathVariable int id, Model model)
    {
        ProductBean produit = produitsProxy.recupererUnProduit(id);
        model.addAttribute("produit", produit);
        return "FicheProduit";
    }

}
