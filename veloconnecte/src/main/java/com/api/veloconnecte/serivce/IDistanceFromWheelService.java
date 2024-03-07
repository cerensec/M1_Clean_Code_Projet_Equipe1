package com.api.veloconnecte.serivce;

public interface IDistanceFromWheelService<T> {
    public double calculateDistanceInMeters(T wheel, int wheelRevolutions);
}
