package com.bootcamp.dominio;

import java.util.Collections;
import java.util.List;

public class Ranking{
	
	private Dev nivelMaisAuto;
	private List<Dev> listaDeDevs;
	
	public Ranking(List<Dev> listaDeDevs) {
		this.listaDeDevs = listaDeDevs;
	}


	public void tabelaRanking() {
		
		System.out.println("\n+================== [ Ranking ] ==================+\n");
		Collections.sort(this.listaDeDevs);
		
		for(int posicao = 0; posicao < this.listaDeDevs.size(); posicao++) {
			System.out.println("+-----------------------------------------+");
			System.out.println("|"+(posicao + 1)+ "º Lugar\n|");
			System.out.println("| Nome: " + this.listaDeDevs.get(posicao).getNome());
			System.out.println("| Nivel: "+ this.listaDeDevs.get(posicao).getNivel());
			System.out.println("+-----------------------------------------+");
			
		}
				
	}
	
}
