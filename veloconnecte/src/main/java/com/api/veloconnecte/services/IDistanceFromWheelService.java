package com.api.veloconnecte.services;

public interface IDistanceFromWheelService<T> {
    public double calculateDistanceInMeters(T wheel, int wheelRevolutions);
}
