package br.edu.infnet;

import br.edu.infnet.exception.ResourceNotFoundException;
import br.edu.infnet.model.Livro;
import br.edu.infnet.util.LivroUtil;

import java.util.Scanner;
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Estamos na API dos Livros de Stephen King");
        Scanner scanner = new Scanner(System.in);
        LivroUtil livroUtil = new LivroUtil();
        System.out.println("Digite sua opcão: ");
        System.out.println("1 - Buscar Livro");
        System.out.println("2 - Buscar Editora");
        int opcaoUsuario = scanner.nextInt();
        switch (opcaoUsuario){
            case 1: {
                System.out.println("Digite o ID do Livro");
                int livroId = scanner.nextInt();
                try{
                    Livro.LivroData livro = livroUtil.getBuyId(livroId).getData();
                    System.out.println("Titulo: " + livro.getTitle());
                    System.out.println("Ano Lançamento: " + livro.getYear());
                } catch (ResourceNotFoundException ex){
                    System.out.println(ex.getMessage());
                }
                break;
            }
            case 2: {
                System.out.println("Digite o ID do Livro");
                int livroId = scanner.nextInt();
                try{
                    Livro.LivroData livro = livroUtil.getBuyId(livroId).getData();
                    System.out.println("Editora: " + livro.getPublisher());
                } catch (ResourceNotFoundException ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
