package com.pwr.bdprojekt.logic;

import com.pwr.bdprojekt.logic.entities.*;

import java.sql.*;

public class DataBaseApi {

//======================================================================================================================
// POLA

	/**
	 * Połączenie z bazą jako użytkownik root
	 * */
	private static Connection root_connection = null;

	/**
	 * Połączenie z bazą jako właściwy użytkownik Bazy Miejscowości
	 * */
	private static Connection user_connection = null;

//======================================================================================================================
// METODY

	/**
	 * Ustanowienie połączenia z bazą danych.
	 * @param login nazwa użytkownika ustanawiającego połączenie
	 * @param password hasło użytkownika ustanawiającego połączenie
	 * */
	public static boolean connect(String login, String password){
		Connection connection_to_establish;

		String url = "jdbc:mariadb://localhost:3306/projekt_bd?user=" + login + "&password=" + password;
		try {
			connection_to_establish = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cannot connect to database as " + login);
			return false;
		}

		if(login.equals("root")){
			root_connection = connection_to_establish;
		}
		else if(root_connection != null){
			user_connection = connection_to_establish;
		}
		else {
			// Jeżeli nie ustanowiono połączenia root, to aplikacja nie powinna pozwolić na nawiązania połączenia
			// użytkownika
			return false;
		}

		System.out.println("Connected to database as " + login);
		return true;
	}

	/**
	 * Zamyka połączenie wskazanego użytkownika
	 * @param login nazwa użytkownika, którego połączenie zamykamy
	 * */
	public static boolean closeConnection(String login){
		Connection connection_to_establish;
		if(login.equals("root")){
			connection_to_establish = root_connection;
		}
		else {
			connection_to_establish = user_connection;
		}

		try {
			connection_to_establish.close();
		} catch (SQLException e) {
			System.out.println("Cannot close connection to database as " + login);
			e.printStackTrace();
			return false;
		}

		System.out.println("Closed connection to database as " + login);
		return true;
	}

	/**
	 * 
	 * @param locality
	 */
	public static boolean addLocalityToFavList(Locality locality) {
		// TODO - implement DataBaseApi.addLocalityToFavList
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attraction
	 */
	public static boolean addNewAttraction(Attraction attraction) {
		// TODO - implement DataBaseApi.addNewAttraction
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param locality
	 */
	public static boolean addNewLocality(Locality locality) {
		// TODO - implement DataBaseApi.addNewLocality
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attraction_id
	 * @param address
	 */
	public static boolean assignAttractionToLocality(String attraction_id, String address) {
		// TODO - implement DataBaseApi.assignAttractionToLocality
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param figure
	 * @param attraction
	 * @param caption
	 */
	public static boolean assignFigureToAttraction(Figure figure, Address attraction, String caption) {
		// TODO - implement DataBaseApi.assignFigureToAttraction
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param user
	 * @param permission
	 * @param voivodship
	 */
	public static boolean assignPermissionToUser(User user, Permission permission, AdministrativeUnit voivodship) {
		// TODO - implement DataBaseApi.assignPermissionToUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attraction
	 * @param type
	 */
	public static boolean assignTypeToAttraction(Attraction attraction, AttractionType type) {
		// TODO - implement DataBaseApi.assignTypeToAttraction
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attraction
	 */
	public static boolean delAttraction(Attraction attraction) {
		// TODO - implement DataBaseApi.delAttraction
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param locality
	 */
	public static boolean delLocality(Locality locality) {
		// TODO - implement DataBaseApi.delLocality
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param locality
	 */
	public static boolean delLocalityFromFavList(Locality locality) {
		// TODO - implement DataBaseApi.delLocalityFromFavList
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param user
	 */
	public static boolean delUser(User user) {
		// TODO - implement DataBaseApi.delUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param locality
	 */
	public static Attraction[] getAttractionsFromLocality(Locality locality) {
		// TODO - implement DataBaseApi.getAttractionsFromLocality
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param voivodship
	 */
	public static AdministrativeUnit[] getCountiesFromVoivodship(AdministrativeUnit voivodship) {
		// TODO - implement DataBaseApi.getCountiesFromVoivodship
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attraction
	 */
	public static FigureAssignedToAttraction[] getFiguresAssignedToAttraction(Attraction attraction) {
		// TODO - implement DataBaseApi.getFiguresAssignedToAttraction
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param locality
	 */
	public static int getLocalitiesNumberOfAttraction(Locality locality) {
		// TODO - implement DataBaseApi.getLocalitiesNumberOfAttraction
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param locality
	 */
	public static Address[] getLocationsFromLocality(Locality locality) {
		// TODO - implement DataBaseApi.getLocationsFromLocality
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param county
	 */
	public static AdministrativeUnit[] getMunicipalitiesFromCounty(AdministrativeUnit county) {
		// TODO - implement DataBaseApi.getMunicipalitiesFromCounty
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attraction
	 */
	public static AttractionType[] getTypesAssignedToAttraction(Attraction attraction) {
		// TODO - implement DataBaseApi.getTypesAssignedToAttraction
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param user
	 * @param voivodship
	 */
	public static Permission[] getUserPermissionsInVoivodship(User user, AdministrativeUnit voivodship) {
		// TODO - implement DataBaseApi.getUserPermissionsInVoivodship
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param user
	 */
	public static AdministrativeUnit[] getVoivodshipsManagedByUser(User user) {
		// TODO - implement DataBaseApi.getVoivodshipsManagedByUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attraction
	 */
	public static boolean modifyAttraction(Attraction attraction) {
		// TODO - implement DataBaseApi.modifyAttraction
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param new_caption
	 */
	public static boolean modifyFigureCaption(String new_caption) {
		// TODO - implement DataBaseApi.modifyFigureCaption
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param locality
	 */
	public static boolean modifyLocality(Locality locality) {
		// TODO - implement DataBaseApi.modifyLocality
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param user
	 * @param new_role
	 */
	public static boolean modifyUserRole(User user, UserRole new_role) {
		// TODO - implement DataBaseApi.modifyUserRole
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param login
	 * @param password
	 */
	public static boolean registerUser(String login, String password) {
		// TODO - implement DataBaseApi.registerUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attraction
	 * @param locality
	 */
	public static boolean unassignAttractionFromLocality(Attraction attraction, Locality locality) {
		// TODO - implement DataBaseApi.unassignAttractionFromLocality
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attraction
	 * @param figure
	 */
	public static boolean unassignFigureFromAttraction(Attraction attraction, Figure figure) {
		// TODO - implement DataBaseApi.unassignFigureFromAttraction
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param user
	 * @param voivodship
	 * @param permission
	 */
	public static boolean unassignPermissionFromUser(User user, AdministrativeUnit voivodship, Permission permission) {
		// TODO - implement DataBaseApi.unassignPermissionFromUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attraction
	 * @param type
	 */
	public static boolean unassignTypeFromAttraction(Attraction attraction, AttractionType type) {
		// TODO - implement DataBaseApi.unassignTypeFromAttraction
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param figure
	 */
	public static boolean addFigure(Figure figure) {
		// TODO - implement DataBaseApi.addFigure
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param figure
	 */
	public static boolean deleteFigure(Figure figure) {
		// TODO - implement DataBaseApi.deleteFigure
		throw new UnsupportedOperationException();
	}

	public static User getCurrentUser() {
		// TODO - implement DataBaseApi.getCurrentUser
		throw new UnsupportedOperationException();
	}

}