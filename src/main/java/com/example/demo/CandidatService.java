package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatService {
	
	@Autowired
	private CandidatRepository candrep;
	
	public Candidat addCandidat(Candidat c) {
		return candrep.save(c);
	}

	public Candidat updateCandidat(int id,Candidat newc) {
		if(candrep.findById(id).isPresent()) {
			Candidat existing = candrep.findById(id).get();
			existing.setNom(newc.getNom());
			existing.setPrenom(newc.getPrenom());
			existing.setMail(newc.getMail());
		return candrep.save(existing);
		}else
			return null;
	}
	
	public String deleteCandidat(int id) {
		if(candrep.findById(id).isPresent()) {
		candrep.deleteById(id);
		return " candidat supprimé ";
		}else
			return " candidat non supprimé ";
	}

}
