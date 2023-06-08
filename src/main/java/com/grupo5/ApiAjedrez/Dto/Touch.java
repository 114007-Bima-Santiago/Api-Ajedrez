package com.grupo5.ApiAjedrez.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Touch {
    private int codTouch;
    public Touch(int codigo){ codTouch = codigo; }
}
