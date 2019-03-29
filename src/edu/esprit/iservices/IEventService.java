/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.iservices;

import edu.esprit.entities.Events;
import java.util.List;

/**
 *
 * @author lhannachi
 */
public interface IEventService {
    
    public void add(Events e);
    public void update(Events e,int id_event);
    public void remove(Events e);
    public List<Events> findAll();
    public Events findById(int id_event);
   
}
