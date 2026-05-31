# Travel Agency GUI Application - Parques Maray 🎢🏨

## Overview
This repository contains a comprehensive desktop graphical user interface (GUI) application built with **Java** and **Eclipse WindowBuilder**. 

Developed as the final project for the "Human-Computer Interaction" (Comunicación Persona-Máquina - CPM) course at the University of Oviedo, this application simulates a complete travel agency booking system specializing in theme parks and associated accommodations. The project was awarded an outstanding grade of **9.75/10**.

## Architectural Design
The application is built upon a robust layered architecture to ensure maintainability and separation of concerns across its +4,000 lines of code:
* **Model (`uo.cpm.modulo.model`):** Core business entities (Agencia, Parque, Alojamiento, Reserva).
* **Service (`uo.cpm.modulo.service`):** Business logic and coordination.
* **UI (`uo.cpm.modulo.ui`):** Frontend interface components.
* **Util (`uo.cpm.modulo.util`):** Helper classes for file I/O and data persistence.

## Key Features & UX
* **Dynamic Panel Navigation:** Instead of opening multiple disjointed windows, the core UI (`VentanaPrincipal`) is designed using a dynamic panel-switching architecture (`PanelParque`, `PanelAlojamiento`, etc.). This ensures a fluid, single-page-like user experience.
* **Complete Booking Flow:** Users can browse parks, view associated accommodations, select dates using interactive calendars (via `jcalendar`), and formalize their reservations.
* **Integrated Help System:** Features a robust, context-sensitive Help System built entirely with **HTML and CSS**, integrated into the Java application using the `JavaHelp` (JHall) library.
* **Gamification:** Includes a post-booking interactive minigame where users can win discounts for future reservations, adding a layer of engagement.
* **Modern Look & Feel:** The interface is modernized using advanced UI libraries such as `FlatLaf` and `JTattoo`.
* **Data Persistence & I/O:** Reads and stores application state, configurations, and bookings via local `.dat` files.

## Technologies & Libraries Used
* **Language:** Java
* **GUI Builder:** Eclipse WindowBuilder (Swing)
* **Architecture:** MVC / Layered Architecture
* **External Libraries:** * `FlatLaf` & `JTattoo` (Custom Look & Feel)
  * `JCalendar` (Date selection)
  * `JavaHelp / JHall` (Integrated HTML/CSS Help System)
  * `BasicPlayer / MP3SPI` (Audio integration)
