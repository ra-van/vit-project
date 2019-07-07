package com.vit.drd.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vit.drd.model.Weapon;
import com.vit.drd.model.WeaponDto;
import com.vit.drd.search.WeaponSearch;

/**
 * MainController class
 */
@Controller
public class MainController {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  // Inject the WeaponSearch object
  @Autowired
  private WeaponSearch weaponSearch;


  // ------------------------
  // PUBLIC METHODS
  // ------------------------

  /**
   * Index main page.
   */
  @RequestMapping("/")
  public String index() {
	  return "index";
  }
  
  
  /**
   * contact main page.
   */
  @RequestMapping("/contact")
  public String contact() {
	  return "contact";
  }

  /**
   * about main page.
   */
  @RequestMapping("/about")
  public String about() {
	  return "about";
  }

  /**
   * Show search results for the given query.
   *
   * @param q The search query.
   */
  @RequestMapping("/search")
  public String search(String q, Model model) {
    List<Weapon> searchResults = null;
    try {
      searchResults = weaponSearch.search(q);
    }
    catch (Exception ex) {
      // here you should handle unexpected errors
      // ...
      // throw ex;
    }
    model.addAttribute("searchResults", mapWeapons(searchResults));
    return "search";
  }
  
  
  private List<WeaponDto> mapWeapons(List<Weapon> searchResults){
	  List<WeaponDto> weapons = new ArrayList<>();
	  
	  for (Weapon weapon : searchResults) {
		  WeaponDto dto = new WeaponDto(weapon.getType(),weapon.getName(),weapon.getCalibre(),weapon.getCountryOfManufacture(),mapDescr(weapon));
		  weapons.add(dto);
	  }
	  
	  return weapons;
  }
  
  private String mapDescr(Weapon weapon) {
	  
	  StringBuilder sb= new StringBuilder("Weapon Description - ");
	  sb.append("StockType :");
	  sb.append(weapon.getStockType());
	  sb.append(",");
	  sb.append("StockMaterial :");
	  sb.append(weapon.getStockMaterial());
	  sb.append(",");
	  sb.append("GripType :");
	  sb.append(weapon.getGripType());
	  sb.append(",");
	  sb.append("GripMaterial :");
	  sb.append(weapon.getGripMaterial());
	  sb.append(",");
	  sb.append("Magazine :");
	  sb.append(weapon.getMagazine());
	  sb.append(",");
	  sb.append("MuzzleDevice :");
	  sb.append(weapon.getMuzzleDevice());
	  sb.append(",");
	  sb.append("FixedAccessories :");
	  sb.append(weapon.getFixedAccessories());
	  return sb.toString();
	  
  }


} // class MainController
