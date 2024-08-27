package fr.ln.nextLine.Service.ServiceExt;

import fr.ln.nextLine.Model.Dto.EntrepriseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    @Autowired
    private CacheManager cacheManager;

    public void cacheEntrepriseDTO(String token, EntrepriseDTO entrepriseDTO) {

        Cache cache = cacheManager.getCache("formulaireCache");

        if (cache != null) {

            cache.put(token, entrepriseDTO);
            System.out.println("EntrepriseDTO depuis le cache : " + entrepriseDTO.getRaisonSociale());
        }
    }

    public EntrepriseDTO getEntrepriseFromCache(String token) {

        Cache cache = cacheManager.getCache("formulaireCache");

        if (cache != null) {

            System.out.println("récupération de l'objet en cache ok");
            return cache.get(token, EntrepriseDTO.class);
        }

        return null;
    }
}
