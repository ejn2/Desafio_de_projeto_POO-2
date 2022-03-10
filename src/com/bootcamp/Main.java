package com.bootcamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bootcamp.dominio.Bootcamp;
import com.bootcamp.dominio.Curso;
import com.bootcamp.dominio.Dev;
import com.bootcamp.dominio.Mentoria;
import com.bootcamp.dominio.Ranking;

public class Main {
    public static void main(String[] args) {
    	
    	
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descricao curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descricao curso js");
        curso2.setCargaHoraria(4);
        

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descricao mentoria java");
        mentoria.setData(LocalDate.now());


        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descricao Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        
        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos Camila:" + devCamila.getConteudosInscritos());
        devCamila.progredir();
        devCamila.progredir();
        System.out.println("-");
        System.out.println("Conteudos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("Conteudos Conclui­dos Camila:" + devCamila.getConteudosConcluidos());
        System.out.println("Nivel: "+devCamila.getNivel());
        System.out.println("XP: "+devCamila.getXpAtual());

        System.out.println("-------");
        
        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos Joo:" + devJoao.getConteudosInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("-");
        System.out.println("Conteudos Inscritos Joao:" + devJoao.getConteudosInscritos());
        System.out.println("Conteudos Concluidos Joao:" + devJoao.getConteudosConcluidos());
        System.out.println("Nivel: "+devJoao.getNivel());
        System.out.println("XP: " + devJoao.getXpAtual());
        
        
        //Ranking
        
        List<Dev> listaDeDevs = new ArrayList<>();
        listaDeDevs.add(devJoao);
        listaDeDevs.add(devCamila);
        
        Ranking ranking = new Ranking(listaDeDevs);
        ranking.tabelaRanking();
        
        
        //Seguindo
        devCamila.seguirDev(devJoao);
        devCamila.devsQueEstouSeguindo();
        
        

    }

}
