/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.web;

import biblioteca.ejb.AssuntoService;
import biblioteca.ejb.TestServiceEJB;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ConfigBean {
    
    @EJB AssuntoService assuntoService;
    @EJB TestServiceEJB testService;
    
    List<String> entidades = new ArrayList<>();
    
    public boolean isAppNova() { 
        try {
            return assuntoService.dataSize() == 0;
        } catch(Exception e) {
            return true; // no tables created
        }
    }

    public List<String> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<String> entidades) {
        this.entidades = entidades;
    }
    
    public String configure() {
        assuntoService.configure();
        return "index";
    }
    
    public String removeAllEntities() {
        testService.removeAllEntities(entidades);
        return "index";
    }
    
    public String createTestData() {
        testService.createTestData();
        return "index";
    }

}
