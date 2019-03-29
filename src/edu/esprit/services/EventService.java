/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Events;
import edu.esprit.iservices.IEventService;
import edu.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author lhannachi
 */
public class EventService implements IEventService{
    
    Connection connection;
    private PreparedStatement ps;
    private DataSource dataSource;

    public EventService() {
        connection = dataSource.getInstance().getConnection();
    }

    @Override
    public void add(Events e) {

        String req = "INSERT INTO event (idevent,iduser,idcat,photo,date_event,description,lat,lon,lieu,video,titre) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, e.getId_event());
            preparedStatement.setInt(2, e.getId_user());
            preparedStatement.setInt(3, e.getId_categorie());
            preparedStatement.setString(4, e.getImage_url());
            preparedStatement.setDate(5, new Date(22/12/2010));
            preparedStatement.setString(6, e.getDescription());
            preparedStatement.setDouble(7, e.getLatitude());
            preparedStatement.setDouble(8, e.getLongitude());
            preparedStatement.setString(9, e.getLocation());
            preparedStatement.setString(10, e.getVideo_url());
            preparedStatement.setString(11, e.getTitle());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();           
        } 
    }

    @Override   
    public void update(Events e, int id_event) {
        String req = "UPDATE event SET iduser=?,idcat =?,photo=?,date_event=?,description=?,lat=?,lon=?,lieu=?,video=?,titre=? WHERE idevent=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, e.getId_user());
            preparedStatement.setInt(2, e.getId_categorie());
            preparedStatement.setString(3, e.getImage_url());
            preparedStatement.setDate(4, new Date(23/12/2013));
            preparedStatement.setString(5, e.getDescription());
            preparedStatement.setDouble(6, e.getLatitude());
            preparedStatement.setDouble(7, e.getLongitude());
            preparedStatement.setString(8, e.getLocation());
            preparedStatement.setString(9, e.getVideo_url());
            preparedStatement.setString(10, e.getTitle());
            preparedStatement.setInt(11, id_event);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(Events e) {
        
        String req = "DELETE FROM event WHERE idevent = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, e.getId_event());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error lors de la supression" + ex.getMessage());
        }
    }

    @Override
    public List<Events> findAll() {
        Events ev = null;
        String req = "SELECT * FROM event";
        List<Events> evenements = new ArrayList<>();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Events evenement = new Events(rs.getInt("idevent"), rs.getInt("iduser"), rs.getInt("idcat"), rs.getString("titre"), rs.getDate("date_event"), rs.getString("description"), rs.getString("lieu"), rs.getString("video"), rs.getString("photo"), rs.getDouble("lon"), rs.getDouble("lat"));
                evenements.add(evenement);
                
            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return evenements;
    }

    @Override
    public Events findById(int id_event) {
        String reqSql = "SELECT * FROM event WHERE idevent = ?";
        Events ev = new Events();
        PreparedStatement preparedStatement;
        try {
            ps = connection.prepareStatement(reqSql);
            ps.setInt(1, id_event);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ev.setId_event(rs.getInt("idevent"));
                ev.setId_user(rs.getInt("iduser"));
                ev.setId_categorie(rs.getInt("idcat"));
                ev.setTitle(rs.getString("titre"));
                ev.setEvent_date(rs.getDate("date_event"));
                ev.setDescription(rs.getString("description"));
                ev.setLocation(rs.getString("lieu"));
                ev.setVideo_url(rs.getString("video"));
                ev.setImage_url(rs.getString("photo"));
                ev.setLongitude(rs.getDouble("lon"));
                ev.setLatitude(rs.getDouble("lat"));
               
            }
        } catch (SQLException ex) {
            System.out.println("erreur " + ex.getMessage());
        }
        return ev;
    }

    
   
}
