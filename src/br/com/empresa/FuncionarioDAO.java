package br.com.empresa;

import java.sql.*;
import java.util.ArrayList;

public class FuncionarioDAO {
    private Connection connect = null;

    public FuncionarioDAO() throws SQLException, ClassNotFoundException {
        connect = BancoConexao.getConnection();
    }

    public void inserirFuncionario(Funcionario f) {
       String sql = "INSERT INTO funcionario (nomefuncionario, telefone, datanascimento, datacontratacao, situacao, cpf, altura, idade, cargo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            connect = BancoConexao.getConnection();
            PreparedStatement stmt = connect.prepareStatement(sql);

            stmt.setString(1, f.getNomefuncionario());
            stmt.setString(2, f.getTelefone());
            stmt.setDate(3, new Date(f.getDatanascimento().getTime()));
            stmt.setDate(4, new Date(f.getDatacontratacao().getTime()));
            stmt.setString(5, f.getSituacao());
            stmt.setString(6, f.getCpf());
            stmt.setFloat(7, f.getAltura());
            stmt.setInt(8, f.getIdade());
            stmt.setLong(9, f.getCargo());
            stmt.executeUpdate();

            System.out.println("\nFuncionário adicionado no sistema\n");

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Funcionario> listarFuncionario() {
        ArrayList<Funcionario> retornafuncionario = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        try {
            connect = BancoConexao.getConnection();

            PreparedStatement stmt = connect.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Funcionario f = new Funcionario();
                f.setIdfuncionario(rs.getLong("idfuncionario"));
                f.setNomefuncionario(rs.getString("nomefuncionario"));
                f.setTelefone(rs.getString("telefone"));
                f.setDatanascimento(rs.getDate("datanascimento"));
                f.setDatacontratacao(rs.getDate("datacontratacao"));
                f.setSituacao(rs.getString("situacao"));
                f.setCpf(rs.getString("cpf"));
                f.setAltura(rs.getFloat("altura"));
                f.setIdade(rs.getInt("idade"));
                f.setCargo(rs.getLong("cargo"));
                retornafuncionario.add(f);
            }

            rs.close();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return retornafuncionario;
    }

    public Funcionario acharFuncionario(Long idfuncionario) {
        Funcionario f = new Funcionario();
        String sql = "SELECT * FROM funcionario WHERE idfuncionario = ?";

        try {
            connect = BancoConexao.getConnection();
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setLong(1, idfuncionario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                f.setIdfuncionario(rs.getLong("idfuncionario"));
                f.setNomefuncionario(rs.getString("nomefuncionario"));
                f.setTelefone(rs.getString("telefone"));
                f.setDatanascimento(rs.getDate("datanascimento"));
                f.setDatacontratacao(rs.getDate("datacontratacao"));
                f.setSituacao(rs.getString("situacao"));
                f.setCpf(rs.getString("cpf"));
                f.setAltura(rs.getFloat("altura"));
                f.setIdade(rs.getInt("idade"));
                f.setCargo(rs.getLong("cargo"));
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return f;
    }

    public void alterarFuncionario(Long idfuncionario, String nomefuncionario, String telefone, java.util.Date datanascimento, java.util.Date datacontratacao, String situacao, String cpf, Float altura, Integer idade, Long cargo) {

        String sql = "UPDATE funcionario SET nomefuncionario = ?, telefone = ?, datanascimento = ?, datacontratacao = ?, situacao = ?, cpf = ?, altura = ?, idade = ?, cargo = ? WHERE idfuncionario = ?";

        try {
            connect = BancoConexao.getConnection();
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setString(1, nomefuncionario);
            stmt.setString(2, telefone);
            // ps.setTimestamp(1, new java.sql.Timestamp(data.getTime()));
            stmt.setDate(3, new java.sql.Date(datanascimento.getTime()));
            stmt.setDate(4, new java.sql.Date(datacontratacao.getTime()));
            //stmt.setDate(4, (Date) datacontratacao);
            stmt.setString(5, situacao);
            stmt.setString(6, cpf);
            stmt.setFloat(7, altura);
            stmt.setInt(8, idade);
            stmt.setLong(9, cargo);
            stmt.setLong(10, idfuncionario);
            stmt.executeUpdate();
            System.out.println("\nFuncionário alterado no sistema\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void excluirFuncionario(Long idfuncionario) {


        String sql = "DELETE FROM funcionario WHERE idfuncionario = ?";

        try {
            connect = BancoConexao.getConnection();

            PreparedStatement stmt1 = connect.prepareStatement(sql);
            stmt1.setLong(1, idfuncionario);
            stmt1.executeUpdate();
            System.out.println("\nFuncionário removido do sistema com sucesso!\n");

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}