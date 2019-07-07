package com.vit.drd.search;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import com.vit.drd.model.Weapon;

/**
 * Search methods for the entity Weapon using Hibernate search.
 * The Transactional annotation ensure that transactions will be opened and
 * closed at the beginning and at the end of each method.
 * 
 */
@Repository
@Transactional
public class WeaponSearch {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // Spring will inject here the entity manager object
  @PersistenceContext
  private EntityManager entityManager;


  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * A basic search for the entity Weapon. The search is done by exact match per
   * keywords on fields name, type etc
   * 
   * ref- https://www.baeldung.com/hibernate-search
   * 
   * @param text The query text.
   */
 
public List<Weapon> search(String text) {
    
    // get the full text entity manager
    FullTextEntityManager fullTextEntityManager =
      org.hibernate.search.jpa.Search.
      getFullTextEntityManager(entityManager);
    
    // create the query using Hibernate Search query DSL
    QueryBuilder queryBuilder = 
      fullTextEntityManager.getSearchFactory()
      .buildQueryBuilder().forEntity(Weapon.class).get();
    
    // a very basic query by keywords
    org.apache.lucene.search.Query query =
      queryBuilder
        .keyword()
        .onFields("name", "type", "calibre","stockType","stockMaterial","gripMaterial","fixedAccessories","muzzleDevice","magazine","countryOfManufacture")
        .matching(text)
        .createQuery();
    
    //Use this to demo Fuzzy query
    @SuppressWarnings("unused")
    org.apache.lucene.search.Query fuzzyQuery = queryBuilder
    		  .keyword()
    		  .fuzzy()
    		  .withEditDistanceUpTo(2)
    		  .withPrefixLength(0)
    		  .onField("name")
    		  .matching(text)
    		  .createQuery();

    // wrap Lucene query in an Hibernate Query object
    org.hibernate.search.jpa.FullTextQuery jpaQuery =
      fullTextEntityManager.createFullTextQuery(query, Weapon.class);
  
    // execute search and return results (sorted by relevance as default)
    @SuppressWarnings("unchecked")
    List<Weapon> results = jpaQuery.getResultList();
    
    return results;
  } // method search


} // class
