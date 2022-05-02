package br.com.empresa;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        Main m = new Main();
        m.menu();
    }

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public void menu() throws SQLException, ClassNotFoundException, ParseException {

        System.out.println("1 - Cadastrar novo cargo");
        System.out.println("2 - Modificar cargo existente");
        System.out.println("3 - Listar cargos existentes");
        System.out.println("4 - Cadastrar novo funcionário");
        System.out.println("5 - Modificar funcionário existente");
        System.out.println("6 - Listar funcionários existentes");
        System.out.println("7 - Excluir funcionário");
        System.out.println("9 - Sair");
        System.out.print("Opção: ");
        int opcao = getScanner().nextInt();

        switch (opcao) {

            case 1:
                inserirCargo();
            case 2:
                alterarCargo();
            case 3:
                listarCargo();
            case 4:
                inserirFuncionario();
            case 5:
                alterarFuncionario();
            case 6:
                listarFuncionario();
            case 7:
                excluirFuncionario();
            case 9:
                System.exit(0);
            default:
                System.out.println("Digite uma opção valida!");
                menu();
        }
    }

    public void retornoMenu() throws SQLException, ParseException, ClassNotFoundException {
        System.out.println("Deseja  retornar para o menu inicial? " +
                "\n1 - Sim " +
                "\n2 - Não");
        int valordigitado = getScanner().nextInt();

        if (valordigitado == 1){
            menu();
        }
        else {
            System.exit(0);
        }
    }

    private void inserirCargo() throws SQLException, ClassNotFoundException, ParseException {

        System.out.print("\nDigite o nome do cargo: ");
        String nomecargo = getScanner().nextLine();
        System.out.print("Digite a descrição do cargo: ");
        String descricaocargo = getScanner().nextLine();

        Cargo c = new Cargo(nomecargo, descricaocargo);
        CargoDAO cdao = new CargoDAO();
        cdao.inserirCargo(c);

        retornoMenu();
    }

    public void listarCargo() throws SQLException, ClassNotFoundException, ParseException {
        CargoDAO cdao = new CargoDAO();

        System.out.println("\t\n--- Todos os cargos existentes na Campo Mágico ---\n");

        for (Cargo c : cdao.listarCargo()) {
            System.out.println("ID: " + c.getIdcargo());
            System.out.println("NOME: " + c.getNomecargo());
            System.out.println("DESCRIÇÃO: " + c.getDescricaocargo());
            System.out.println("-----------------\n");
        }
        retornoMenu();
    }

    public void alterarCargo() throws SQLException, ClassNotFoundException, ParseException {
        CargoDAO cdao = new CargoDAO();

        System.out.print("\nDigite o ID do cargo a ser alterado: ");
        Long idcargo = getScanner().nextLong();

        Cargo c = cdao.acharCargo(idcargo);

        System.out.println("Digite as novas informações: \n");

        System.out.print("Nome do cargo: ");
        String nomecargo = getScanner().nextLine();
        System.out.print("Descrição do cargo: ");
        String descricaocargo = getScanner().nextLine();

        cdao.alterarCargo(c.getIdcargo(), nomecargo, descricaocargo);

        retornoMenu();
    }

    private void inserirFuncionario() throws SQLException, ClassNotFoundException, ParseException {

        System.out.print("\nNome: ");
        String nomefuncionario = getScanner().nextLine();

        System.out.print("Telefone: ");
        String telefone = getScanner().nextLine();

        System.out.print("Data de nascimento dd/mm/yyyy: ");
        String datan = getScanner().nextLine();
        SimpleDateFormat sdff = new SimpleDateFormat("dd/MM/yyyy");
        Date datanascimento = sdff.parse(datan);

        System.out.print("Data de contratação dd/mm/yyyy: ");
        String datac = getScanner().next();
        Date datacontratacao = sdff.parse(datac);

        System.out.print("Situação: ");
        String situacao = getScanner().nextLine();

        System.out.print("CPF: ");
        String cpf = getScanner().nextLine();

        System.out.print("Altura: ");
        Float altura = getScanner().nextFloat();

        System.out.print("Idade: ");
        Integer idade = getScanner().nextInt();

        System.out.println("Id do cargo: ");
        Long cargo = getScanner().nextLong();

        Funcionario f = new Funcionario(nomefuncionario, telefone, datanascimento, datacontratacao, situacao, cpf, altura, idade, cargo);
        FuncionarioDAO fdao = new FuncionarioDAO();
        fdao.inserirFuncionario(f);

        retornoMenu();
    }

    public void listarFuncionario() throws SQLException, ClassNotFoundException, ParseException {

        FuncionarioDAO fdao = new FuncionarioDAO();
        System.out.println("\t\n--- Listagem de todos os funcionários ---\n");
        for (Funcionario f : fdao.listarFuncionario()) {
            System.out.println("ID: " + f.getIdfuncionario());
            System.out.println("Nome: " + f.getNomefuncionario());
            System.out.println("Telefone: " + f.getTelefone());
            System.out.println("Data de nascimento: " + f.getDatanascimento());
            System.out.println("Data de contratação: " + f.getDatacontratacao());
            System.out.println("Situação: " + f.getSituacao());
            System.out.println("CPF: " + f.getCpf());
            System.out.println("Altura: " + f.getAltura());
            System.out.println("Idade: " + f.getIdade());
            System.out.println("Id do cargo: " + f.getCargo());
            System.out.println("-----------------\n");
        }
        retornoMenu();
    }

    public void alterarFuncionario() throws SQLException, ClassNotFoundException, ParseException {

        FuncionarioDAO fdao = new FuncionarioDAO();

        System.out.print("\nDigite o ID do funcionário para fazer as alterações: ");
        Long idfuncionario = getScanner().nextLong();

        Funcionario f = fdao.acharFuncionario(idfuncionario);

        System.out.println("Digite as novas informações: \n");

        System.out.print("Nome: ");
        String nomefuncionario = getScanner().nextLine();

        System.out.print("Telefone: ");
        String telefone = getScanner().nextLine();

        System.out.print("Data de nascimento dd/mm/yyyy: ");
        String datan = getScanner().nextLine();
        SimpleDateFormat sdff = new SimpleDateFormat("dd/MM/yyyy");
        Date datanascimento = (Date) sdff.parse(datan);

        System.out.print("Data de contratação dd/mm/yyyy: ");
        String datac = getScanner().next();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date datacontratacao = (Date) sdf.parse(datac);

        System.out.print("Situação: ");
        String situacao = getScanner().nextLine();

        System.out.print("CPF: ");
        String cpf = getScanner().nextLine();

        System.out.print("Altura: ");
        Float altura = getScanner().nextFloat();

        System.out.print("Idade: ");
        Integer idade = getScanner().nextInt();

        System.out.println("Id do cargo: ");
        Long cargo = getScanner().nextLong();

        fdao.alterarFuncionario(f.getIdfuncionario(), nomefuncionario, telefone, datanascimento, datacontratacao, situacao, cpf, altura, idade, cargo);
        retornoMenu();
    }

    public void excluirFuncionario() throws SQLException, ClassNotFoundException, ParseException {

        FuncionarioDAO fdao = new FuncionarioDAO();
        System.out.print("\nDigite o número do ID do funcionário que será removido: ");
        Long idfuncionario = getScanner().nextLong();
        fdao.excluirFuncionario(idfuncionario);
        retornoMenu();
    }
}