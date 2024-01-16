package com.pwr.bdprojekt.gui;

import com.pwr.bdprojekt.gui.displays.*;
import com.pwr.bdprojekt.gui.events.*;
import com.pwr.bdprojekt.logic.Application;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

/**
 * Okno aplikacji
 */
public class Window {

	public static JFrame frame = null;
	private static ViewType current_view_type = ViewType.EMPTY;  	// Typ aktualnego widoku
	private static ViewType previous_view_type = ViewType.EMPTY; 	// Typ porzedniego widoku
	private static View current_view = null;						// aktualny widok
	private static EventHandler event_handler = null;				// obsługa zdarzeń

	/**
	 * Pobranie typu aktualnego widoku.
	 */
	public static ViewType getCurrentViewType() {
		// TODO - implement Window.getCurrentViewType
		throw new UnsupportedOperationException();
	}

	/**
	 * Przełączenie aktualnego widoku
	 * @param new_view_type widok, na który chcemy się przełączyć
	 */
	public static void switchToView(ViewType new_view_type, String[] data)
	{
		current_view_type = new_view_type;
		switch (current_view_type)
		{
			case HOME_ADMIN_TECH:
					current_view = new HomeView(frame,true, event_handler);
					break;
			case HOME:
					current_view = new HomeView(frame, false, event_handler);
					break;
			case ADDRESS_EDITOR:
					current_view = new AddressEditorView(frame, event_handler);
					break;
			case ATTRACTION_EDITOR:
					current_view = new AttractionEditorView(frame, event_handler);
					break;
			case LOCALITY_EDITOR:
					current_view = new LocalityEditorView(frame, event_handler);
					break;
			case PERMISSION_EDITOR:
					current_view = new PermissionInRegionEditorView(frame, event_handler);
					break;
			case PERMISSION_TO_REGION_EDITOR:
					current_view = new PermissionToRegionEditorView(frame, event_handler);
					break;
			case LOCALITY_FILTER:
					current_view = new LocalityFilteringView(frame, event_handler);
					break;
			case USERS_FILTER:
					break;
			case LOCALITY_LIST_ADMIN_MERIT:
					break;
			case LOCALITY_LIST:
					break;
			case USERS_LIST:
					break;
			case LOGIN:
					current_view = new LoginView(frame, event_handler);
					break;
			case ASSIGN_ATTRACTION:
					break;
			case ASSIGN_ADDRESS:
					break;
			case ASSIGN_FIGURE:
					break;
			case LOCALITY_SORT:
					break;
			case USERS_SORT:
					break;
			case LOCALITY_DATA:
					break;
			case LOCALITY_DATA_ADMIN_MERIT:
					break;
			case USER_DATA_ADMIN_TECH:
					break;
			case USER_DATA:
					break;
			case EMPTY:
					break;
		}
		current_view.refresh(data);
	}

	/**
	 * Od�wie�enie aktualnego widoku
	 */
	public static void refresh() {
		// TODO - implement Window.refresh
		throw new UnsupportedOperationException();
	}

	/**
	 * Pobranie typu uprzednio otwartego widoku
	 */
	public static ViewType getPreviousDisplayType() {
		// TODO - implement Window.getPreviousDisplayType
		throw new UnsupportedOperationException();
	}

	/**
	 * Otwiera okno aplikacji w domyślnym widoku (logowania). Zwraca informacje o powodzeniu akcji.
	 * @param name tytuł okna
	 * @param w szerokośc okna
	 * @param h wysokość okna
	 */
	public static boolean open(String name, int w, int h) {
		frame = new JFrame(name);
		frame.setSize(w, h);
		frame.setResizable(false);
		frame.setVisible(true);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				Application.quit();
			}
		});

		event_handler = new EventHandler(current_view);

		String[] data = new String[]{
			"user 1",
			"rola użytkownika",
			"Wrocław",
			String.join(",", new String[]{"3, 15"}),
			String.join(",", new String[]{"1000, 15000"}),
			String.join(",", new String[]{"typ1", "typ2", "typ3", "typ4", "typ5"}),
			String.join(",", new String[]{"1", "2", "4"}),
			String.join(",", new String[]{"typ1", "typ2", "typ3", "typ4", "typ5"}),
			String.join(",", new String[]{"0", "2"}),
			String.join(",", new String[]{"woj1", "woj2", "woj3", "woj4", "woj5"}),
			String.join(",", new String[]{"0", "1", "2"}),
			String.join(",", new String[]{"pow1", "pow2", "pow3", "pow4", "pow5"}),
			String.join(",", new String[]{"0"}),
			String.join(",", new String[]{"gm1", "gm2", "gm3", "gm4", "gm5"}),
			String.join(",", new String[]{"1", "2"}),
		};
		switchToView(ViewType.LOCALITY_FILTER, data);

		return true;
	}

	/**
	 * Zamyka okno aplikacji. Zwraca informacje o powodzeniu akcji.
	 */
	public static boolean close() {
		frame.setVisible(false);
		frame.dispose();

		return true;
	}

	public static void showMessageBox(String message){
		JOptionPane.showMessageDialog(frame, message);
	}

}