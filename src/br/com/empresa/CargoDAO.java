package br.com.empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CargoDAO {
    private Connection connect = null;

    public CargoDAO() throws SQLException, ClassNotFoundException {
        connect = BancoConexao.getConnection();
    }

    public void inserirCargo(Cargo c) {
        String sql = "INSERT INTO cargo (nomecargo, descricaocargo) VALUES (?, ?)";

        try {
            connect = BancoConexao.getConnection();
            PreparedStatement stmt = connect.prepareStatement(sql);

            stmt.setString(1, c.getNomecargo());
            stmt.setString(2, c.getDescricaocargo());
            stmt.execute();
            System.out.println("\nCargo adicionado no sistema!\n");

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Cargo> listarCargo() {

        ArrayList<Cargo> retornacargo = new ArrayList<>();
        String sql = "SELECT * FROM cargo";

        try {
            connect = BancoConexao.getConnection();
            PreparedStatement stmt = connect.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Cargo c = new Cargo();
                c.setIdcargo(rs.getLong("idcargo"));
                c.setNomecargo(rs.getString("nomecargo"));
                c.setDescricaocargo(rs.getString("descricaocargo"));
                retornacargo.add(c);
            }
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return retornacargo;
    }

    public Cargo acharCargo(Long idcargo) {
        Cargo c = new Cargo();
        String sql = "SELECT * FROM cargo WHERE idcargo = ?";

        try {
            connect = BancoConexao.getConnection();
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setLong(1, idcargo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                c.setIdcargo(rs.getLong("idcargo"));
                c.setNomecargo(rs.getString("nomecargo"));
                c.setDescricaocargo(rs.getString("descricaocargo"));
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return c;
    }


    public void alterarCargo(Long idcargo, String nomecargo, String descricaocargo) {
        String sql = "UPDATE cargo SET nomecargo = ?, descricaocargo = ? WHERE idcargo = ?";

        try {
            connect = BancoConexao.getConnection();
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setString(1, nomecargo);
            stmt.setString(2, descricaocargo);
            stmt.setLong(3, idcargo);
            stmt.executeUpdate();

            System.out.println("\nCargo modificado com sucesso!\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}