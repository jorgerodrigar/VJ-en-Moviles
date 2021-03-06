package es.ucm.fdi.interfaces;

import java.util.ArrayList;

import es.ucm.fdi.utils.Vector2;

/**
 * Interfaz que encapsula la informacion de los eventos recibidos, almacenandolos
 * en una lista de eventos
 */
public interface InputInterface {

    enum EventType { Clicked, Entered, Exited, Pressed, Released, Dragged, Moved }

    class TouchEvent{
        private EventType event_;
        private int id_;
        private Vector2 position_;
        private String message_;

        public TouchEvent(EventType event, int id, int x, int y){
            event_ = event;
            id_ = id;
            position_ = new Vector2(x, y);
            message_ = "";
        }

        public void setMessage(String message){ message_ = message; }

        public String getMessage(){ return message_; }
        public EventType getEventType(){ return event_; }
        public int getID(){ return id_; }
        public Vector2 getPosition(){ return position_; }
    }

    public ArrayList<TouchEvent> getTouchEvents();
}
