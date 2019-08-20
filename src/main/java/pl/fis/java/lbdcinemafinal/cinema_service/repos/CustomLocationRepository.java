package pl.fis.java.lbdcinemafinal.cinema_service.repos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class CustomLocationRepository implements ICustomLocationRepository
{
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<String> fetchCities()
	{
		Query query = em.createQuery("Select distinct l.city from Location l");
		@SuppressWarnings("unchecked")
		List<String> results = query.getResultList();

		return results;
	}

}
