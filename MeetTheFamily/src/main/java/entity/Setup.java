package entity;

import service.inter.Execute;
import service.interImpl.ForChild;
import service.interImpl.ForOthers;

public enum Setup {
    GET_RELATIONSHIP{
        @Override
        public Execute getExecute(){
            return new ForOthers();
        }
    },
    ADD_CHILD{
        @Override
        public Execute getExecute(){
            return new ForChild();
        }
    };
    public abstract Execute getExecute();
}
