# Final_project
Final project for Coders Lab

“Fiesta app” is designed to help users manage events, especially house-parties. 

The main aim of the app is to help users determine budget that will be needed for the party, depending on the amount of the people, by having access to data from previous events.
 Other users, that will attend the party, can contribute by posting on the event page what they will bring from food and drinks. 

Screenshot "show_event.jpg" shows the main page of the event where users can add/delete food/drinks that they'll bring to the party.

To have access to the app, users need to register or log in, if they already have an account (technology used: Spring Security)

When creating an event, program assigns event to the user by using @AuthenticationPrincipal.

Users account shows events they hosted/organized.

Further implementations:

- invite other users;
- upload photos;
- a page with data from parties, so everyone have access to data needed in creating a budget.
- after the party, only owner of the party will be able to change data

Technologies used: Spring, Hibernate, MySQL, Spring Security, HTML, CSS, Servlets, JSP
