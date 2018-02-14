package com.example.demo;
import org.springframework.data.repository.CrudRepository;
public  interface RoomRepository extends CrudRepository<Room , Long>{
    /*Iterable<Room> findAllByisRented(boolean isRented);
    Iterable<Room> findAllByisRentedAndisPrivate(boolean isPrivate);
    */
}


