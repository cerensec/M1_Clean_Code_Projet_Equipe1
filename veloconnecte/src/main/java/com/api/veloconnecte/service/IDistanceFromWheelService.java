package com.api.veloconnecte.service;

public interface IDistanceFromWheelService<T> {
    public double calculateDistanceInMeters(T wheel, int wheelRevolutions);
}
