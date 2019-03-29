package edu.esprit.services;

import edu.esprit.entities.Reclamation;
import edu.esprit.entities.TypeReclamation;
import edu.esprit.iservices.IReclamationService;
import edu.esprit.iservices.ITypeReclamation;
import edu.esprit.utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeReclamationService implements ITypeReclamation {
    Connection connection;
    private PreparedStatement ps;
    private DataSource dataSource;


    public TypeReclamationService() {
        connection = dataSource.getInstance().getConnection();

    }


    @Override
    public ArrayList<TypeReclamation> getTypeReclmationList() {
        ArrayList<TypeReclamation> listTypeReclamations = new ArrayList<>();
        try {
            String query = "select * from `typereclamation`;";

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                TypeReclamation tr = new TypeReclamation();
                tr.setId(rs.getInt(1));
                tr.setDescription(rs.getString(2));


                listTypeReclamations.add(tr);

            }
            return listTypeReclamations;
        } catch (SQLException e) {
            System.out.println("erreur liste " + e.getMessage());        }





        return null;
    }

    @Override
    public TypeReclamation getTypeReclmation(int id) {
        String query = "SELECT * FROM `typereclamation` WHERE `id`='"+id+"'";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();


            TypeReclamation tr = new TypeReclamation();
            while (rs.next()) {


                tr.setId(rs.getInt(1));
                tr.setDescription(rs.getString(2));


            }
            return tr;

        } catch (SQLException ex) {

            System.out.println("erreur getTypeReclmation" + ex.getMessage());
        }
        return null;
    }

    @Override
    public void addType(TypeReclamation tr) {

        try {
            String query = "INSERT INTO `reclamation` VALUES (null, ? );";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1,tr.getDescription());


            System.out.println(ps);
            ps.executeUpdate();
            System.out.println("a typeReclamation has been added successfully ");


        } catch (SQLException e) {
            System.out.println("erreur lors de l'insertion d'une typereclamation" + e.getMessage());
        }

    }

    @Override
    public void updateType(TypeReclamation tr) {

    }

    @Override
    public void deleteType(TypeReclamation tr) {

    }
}
