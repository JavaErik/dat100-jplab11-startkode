package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {
	
	private Innlegg[] innleggtabell;
	private int nesteledig;

	// TODO: objektvariable 

	public Blogg() {
		
		this.innleggtabell = new Innlegg[20];
		this.nesteledig = 0;
	}

	public Blogg(int lengde) {
		this.innleggtabell = new Innlegg[lengde];
		this.nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {

		for (int i = 0; i < nesteledig; i++) {
		if (innleggtabell[i].erLik(innlegg)) {
			return i;
		}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return finnInnlegg(innlegg) != -1;
	}

	public boolean ledigPlass() {
		return nesteledig < innleggtabell.length;

	}
	
	public boolean leggTil(Innlegg innlegg) {
	        if (!finnes(innlegg) && ledigPlass()) {
	            innleggtabell[nesteledig] = innlegg;
	            nesteledig++;
	            return true;
	        }
	        return false;
  }
	
	public String toString() {
		StringBuilder result = new StringBuilder();
        result.append(nesteledig).append("\n");

        for (int i = 0; i < nesteledig; i++) {
            result.append(innleggtabell[i].toString()).append("\n");
        }

        return result.toString();
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] nyTabell = new Innlegg[innleggtabell.length * 2];
        System.arraycopy(innleggtabell, 0, nyTabell, 0, nesteledig);
        innleggtabell = nyTabell;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		 if (!finnes(innlegg)) {
	            if (!ledigPlass()) {
	                utvid();
	            }
	            innleggtabell[nesteledig] = innlegg;
	            nesteledig++;
	            return true;
	        }
	        return false;
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		 int indeks = finnInnlegg(innlegg);
	        if (indeks != -1) {
	            for (int i = indeks; i < nesteledig - 1; i++) {
	                innleggtabell[i] = innleggtabell[i + 1];
	            }
	            nesteledig--;
	            return true;
	        }
	        return false;
	}
	
	public int[] search(String keyword) {
		
		 return null;

	}
}