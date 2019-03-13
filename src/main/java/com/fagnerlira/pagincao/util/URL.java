package com.fagnerlira.pagincao.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {

	/*
	//http://localhost:8080/usuarios/paginacao/?nome=Maria
	 * 
	 * Para usar nome=Maria
	 *  
	let uri = 'https://mozilla.org/?x=шеллы';
	let encoded = encodeURI(uri);
	console.log(encoded);
	// output: "https://mozilla.org/?x=%D1%88%D0%B5%D0%BB%D0%BB%D1%8B"

	try {
	  console.log(decodeURI(encoded));
	  // output: "https://mozilla.org/?x=шеллы"
	} catch(e) { // catches a malformed URI
	  console.error(e);
	}
	*/
	
	
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} 
		catch (UnsupportedEncodingException e) {
			return "";
		}
	}	
	
	public static List<Integer> decodeIntList(String s) {
		String[] vet = s.split(",");
		List<Integer> list = new ArrayList<>();
		for (int i=0; i<vet.length; i++) {
			list.add(Integer.parseInt(vet[i]));
		}
		return list;
		//return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
	}
}