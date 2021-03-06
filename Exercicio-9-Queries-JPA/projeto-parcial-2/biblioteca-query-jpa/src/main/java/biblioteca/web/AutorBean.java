/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.web;

import biblioteca.ejb.AutorService;
import biblioteca.jpa.Autor;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class AutorBean {
    @EJB AutorService service;
    
    private Autor current; 
    
    // EXERCÍCIO: crie uma propriedade para guardar o texto que será usado
    // para filtrar os autores pelo nome (+ getter/setter)
    
    @PostConstruct
    public void init() {
        current = new Autor();
    }

    public Autor getCurrent() {
        return current;
    }
    
    public Collection<Autor> getAutores() {
        // EXERCICIO: substitua a chamada getAll() abaixo pela operação que retorna apenas
        // autores filtrados pelo texto digitado
        return service.getAll();
    }
    
    public Autor findByID(int id) {
        return service.findByID(id);
    }

    public void setCurrent(Autor autor) {
        this.current = autor;
    }
    
    public String gravar() {
        service.update(current);
        return "autores";
    }
    
    public String delete(Autor autor) {
        service.delete(autor);
        return "autores";
    }
    
    public String edit(Autor autor) {
        this.setCurrent(autor);
        return "autor";
    }
}
