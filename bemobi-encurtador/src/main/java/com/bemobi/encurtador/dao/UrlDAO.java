package com.bemobi.encurtador.dao;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bemobi.encurtador.domain.Url;
import com.bemobi.encurtador.manager.DynamoDBManager;

/**
 * DAO class for data manipulation on Url class.
 * 
 * Class <code>UrlDAO</code>.
 * 
 * @author Yasmin Romi
 * @version 1.0 (13/05/2018)
 */
public class UrlDAO {

	/** mapper */
    private static final DynamoDBMapper mapper = DynamoDBManager.mapper();

    /** instance */
    private static volatile UrlDAO instance;

    /** makes simple instance private */
    private UrlDAO() { }

    /**
     * instance method for UrlDAO
     * 
     * @return UrlDAO instance
     */
    public static UrlDAO instance() {

        if (instance == null) {
            synchronized(UrlDAO.class) {
                if (instance == null)
                    instance = new UrlDAO();
            }
        }
        return instance;
    }

    /**
     * finds an Url object by its HashKey
     * 
     * @param alias
     * 			alias
     * 
     * @return url
     */
	public Url findUrlByAlias(String alias) {
		
		Url url = mapper.load(Url.class, alias);

        return url;
	}

	/**
	 * Save or update an Url object
	 * 
	 * @param url
	 * 			url
	 * 
	 * @return savedUrl
	 */
	public Url saveOrUpdateUrl(Url url) {

		mapper.save(url);
		
		return mapper.load(Url.class, url.getAlias());
	}

}
