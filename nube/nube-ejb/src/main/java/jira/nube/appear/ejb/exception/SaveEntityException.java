package jira.nube.appear.ejb.exception;

public class SaveEntityException extends Exception{

        public SaveEntityException(String msg){
            super(msg);
        }

        public SaveEntityException(String msg, Throwable a){
            super(msg,a);
        }
}


