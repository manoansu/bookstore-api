package aulaTeste;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Programas {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Map<String, Integer> votes = new HashMap<>();

		System.out.println("Enter file full path:");
		String path = sc.nextLine(); // le a proxima linha..

		try (BufferedReader br = new BufferedReader(new FileReader(path))){

			String line = br.readLine(); // lê uma linha
			while (line != null) {// enquanto a linha nao for nula, processa uma linha.
				
				String[] fields = line.split(",");//separa o campo com virgula
				String name = fields[0];
				int count = Integer.parseInt(fields[1]);
				
				if(votes.containsKey(name)) { // se a chave contem o nomes de candidato..
					int votesSoFar = votes.get(name);// pega o nome de cadidato
					votes.put(name, count + votesSoFar); //inclui e associa o nome com o valor de candidato..
				}else { // caso o votes nao contem o valor / se é a 1ª vez que ele entra..
					votes.put(name, count);// ele apenas inclui chave(nome) e o valor(valr de votos de candidato) ..
				}
				line = br.readLine(); //lê a proxima linha
			}
			
			for(String key : votes.keySet()) { // precorre o hashMap..
				System.out.println(key + ":" + votes.get(key));// apenas imprime o chave e o valor em cada iteração
			}
			

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}
}
