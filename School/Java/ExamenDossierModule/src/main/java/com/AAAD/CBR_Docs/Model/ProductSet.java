package com.AAAD.CBR_Docs.Model;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 26-11-2019
 * Project: CBRDocs - Examendossier
 * Bestandsnaam: ProductSet.java
 */

public class ProductSet 
{
	protected String productCode;
	protected String productNaam;	
	
	protected String getProductCode() {
		return productCode;
	}

	protected void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	protected String getProductNaam() {
		return productNaam;
	}

	protected void setProductNaam(String productNaam) {
		this.productNaam = productNaam;
	}

	public ProductSet()
	{
		
	}
}
