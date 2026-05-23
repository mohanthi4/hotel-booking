package com.app.views;

import java.io.Serializable;

public record HotelView(String id, String name, String city) implements Serializable {
}
