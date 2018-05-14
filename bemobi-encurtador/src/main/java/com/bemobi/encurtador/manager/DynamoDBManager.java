package com.bemobi.encurtador.manager;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

/**
 * DynamoDB mapper manager.
 * 
 * Class <code>DynamoDBManager</code>.
 * 
 * @author Yasmin Romi
 * @version 1.0 (13/05/2018)
 */
public class DynamoDBManager {

	/** instance */
	private static volatile DynamoDBManager instance;

	/** mapper */
    private static DynamoDBMapper mapper;

    /**
     * Instantiates a new DynamoDBManager object
     */
	private DynamoDBManager() {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
        mapper = new DynamoDBMapper(client);
    }

	/**
	 * gets a DynamoDBManager object instance
	 * 
	 * @return DynamoDBManager instance
	 */
    public static DynamoDBManager instance() {

        if (instance == null) {
            synchronized(DynamoDBManager.class) {
                if (instance == null)
                    instance = new DynamoDBManager();
            }
        }

        return instance;
    }

    /**
     * obtains DynamoDB mapper object
     * 
     * @return mapper
     */
    @SuppressWarnings("static-access")
	public static DynamoDBMapper mapper() {

        DynamoDBManager manager = instance();
        return manager.mapper;
    }
}
