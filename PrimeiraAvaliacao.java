import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Primeira Avaliação - POO
    Professor Jackson Machado
    Aluna Kemily Teixeira
    2022.2

    Método de Ordenação: Insertion Sort
*/

public class PrimeiraAvaliacao {
    public static void main(String[] args) {

        //Leitura de arquivo
        String arquivo = "ArquivoLeitura.txt";
        int contador = 0;

        try {
            FileReader leituraArquivo = new FileReader(arquivo);
            BufferedReader leitor = new BufferedReader(leituraArquivo);

            String linha = "";

            do {
                linha = leitor.readLine();
                if (linha != null) {
                    contador++; //Contador de linhas do arquivo, determina o tamanho do array
                }
            } while (linha != null);

            leitor.close();
            leituraArquivo.close();

        } catch (Exception e) {
            System.out.println("Arquivo inexistente!");            
        } 

        //Criação de Array -> Nova leitura do arquivo para armazenar no array
        String[] listaDesordenada = new String[contador];
        int [] listaConvertida = new int[contador];
         
        try {
            FileReader novaLeitura = new FileReader(arquivo);
            BufferedReader novoLeitor = new BufferedReader(novaLeitura);

            for (int i = 0; i < contador; i++) {
                listaDesordenada[i] = novoLeitor.readLine(); //Armazena as linhas do arquivo no array
            }

            novoLeitor.close();
            novaLeitura.close();

        } catch (Exception e) {
            System.out.println("Arquivo não encontrado!");
        }

        //Ordenação da Array
        for (int i = 0; i < contador; i++) {
            listaConvertida[i] = Integer.parseInt(listaDesordenada[i]); //Converte o array de String para Int
        }

        //Metodo Insertion Sort
        for (int j = 0; j < contador; j++) {  
            int chave = listaConvertida[j];  //chave recebe o valor do array na posição j
             
            int i = j-1; //i recebe o valor de j - 1, assim o while começa a verificar a posição anterior a chave, pulando a primeira posição do array

            while ( (i > -1) && ( listaConvertida [i] > chave ) ) {  //Enquanto o valor de i for maior que -1 e o valor da posição i for maior que a chave, o while continua
                listaConvertida [i+1] = listaConvertida [i];  
                i--;  //i recebe o valor de i - 1, assim o while continua verificando a posição anterior a chave
            }  

            listaConvertida[i+1] = chave; //Quando o while termina, a chave recebe o valor da posição i + 1
            System.out.println(j+1 + "º passo -> " + Arrays.toString(listaConvertida)); //Imprime o array a cada passo do Insertion Sort
        }

        //Ordenação da Collection
        List <Integer> collectionOrdenada = new ArrayList<Integer>();

        for (int i = 0; i < contador; i++) {
            collectionOrdenada.add(listaConvertida[i]);
        }

        //Impressão valores em Tela
        System.out.println("Array ordenada: " + Arrays.toString(listaConvertida));
        System.out.println("Collection ordenada: " + collectionOrdenada);

        //Salvar em arquivo
        try {
            FileWriter arquivoSaida = new FileWriter("ArquivoSaida.txt");
            PrintWriter gravarArquivo = new PrintWriter(arquivoSaida);

            gravarArquivo.println("Array ordenada: " + Arrays.toString(listaConvertida));
            gravarArquivo.println("Collection ordenada: " + collectionOrdenada);

            gravarArquivo.close();
            arquivoSaida.close();
        } catch (IOException e) {
            System.out.println("Imporssível criar arquivo!");
        }
    }
}