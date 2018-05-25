/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;

/**
 *
 * @author maicok
 */
public class Arquivo {
    private String texto;
    
    public void salvarTexto(String texto){
        
        try {
             //imprime na impressora
             //Cria o fFileChoose
            JFileChooser chooser = new JFileChooser();
            //Retorna o botão precionado
            int showOpenDialog = chooser.showSaveDialog(null);
            
            
            //Retorna o caminho absoluto do arquivo selecionado ou escolhido como nome
            String name = chooser.getSelectedFile().getAbsolutePath();
        
            //A partir daqui os dados sao gravados no arquivo
            FileWriter arq = new FileWriter(name);
            //Abre espaco na memoria RAM
            PrintWriter gravarArq = new PrintWriter(arq);
            //Manda gravar o texto dentro da memoria
            gravarArq.printf(texto);
           
            //Grava em definitivo no disco
            arq.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
      
        }
    }
    public String lerArquivo(){
    String retorno = "";

    try {
          JFileChooser chooser = new JFileChooser();
            //Retorna o botão precionado
            int showOpenDialog = chooser.showSaveDialog(null);
            
            
            //Retorna o caminho absoluto do arquivo selecionado ou escolhido como nome
            String name = chooser.getSelectedFile().getAbsolutePath();
            
      //Aqui você passa o caminho do arquivo. podem mudar para dar a janela de seleção
      FileReader arq = new FileReader(name);
      BufferedReader lerArq = new BufferedReader(arq);
    
      String linha = lerArq.readLine(); // lê a primeira linha
        // a variável "linha" recebe o valor "null" quando o processo
        // de repetição atingir o final do arquivo texto
      while (linha != null) {

        retorno+=linha+"\n";  //%s
        linha = lerArq.readLine(); // lê da segunda até a última linha
      }
 
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }

    return retorno;

    }
}

