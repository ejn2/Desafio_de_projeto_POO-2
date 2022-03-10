package com.bootcamp.dominio;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev implements Comparable<Dev>{
	
    private String nome;
    private int nivel = 1;
    private double xpAtual = 0;
    private Set<Dev> seguir = new  LinkedHashSet<>();
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    
    public Dev() {
    	
    }
   
	public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.calcularTotalXp();
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Voce naoo esta matriculado em nenhum conteudo!");
        }
    }

    private void calcularTotalXp() {
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        
        double soma = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcularXp();

            soma += next;
        }
        
        if(soma > this.xpAtual)
        	this.nivel++;
        
        this.xpAtual = soma;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }
    
  
	
	public void seguirDev(Dev dev) {
		this.seguir.add(dev);
		System.out.println("* Você agora está seguindo "+dev.getNome() + " *");
	}
	
	public void devsQueEstouSeguindo() {
		
		System.out.println("+============= [ Estou Seguindo ] ============= +");
		for(Dev dev : this.seguir) {
			System.out.println("+------------------------------------+");
			System.out.println("| Nome: "+dev.getNome());
			System.out.println("| Nivel: "+dev.getNivel());
			System.out.println("+------------------------------------+");
		}
	}
		
    public int getNivel() {
		return nivel;
	}

	public double getXpAtual() {
		return xpAtual;
	}
	
	
	public Set<Dev> getSeguir() {
		return seguir;
	}

	
	
	@Override
	public int compareTo(Dev o) {
		
		if(this.getNivel() > o.getNivel())
			return -1;
		
		if(this.getNivel() < o.getNivel())
			return 1;
		
		return 0;
	}
	
}
