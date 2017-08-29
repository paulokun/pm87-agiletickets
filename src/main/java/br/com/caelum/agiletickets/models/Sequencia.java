package br.com.caelum.agiletickets.models;

public class Sequencia {
	public int pegaNumero (int posicao) {
		int penultimo = 0;
		int anterior = 1;
		int eleMesmo = 0;
		
		for (int i = 1; i < posicao; i++) {
			eleMesmo = penultimo + anterior;
			penultimo = anterior;
			anterior = eleMesmo;
		}
		
		return eleMesmo;
	}
}
