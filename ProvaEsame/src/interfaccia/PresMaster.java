package interfaccia;

import Exception.LimitException;

public interface PresMaster  {
	void Ruota(int g);
	void Avanti(int s) throws LimitException;
	void Indietro(int s) throws LimitException;

}
