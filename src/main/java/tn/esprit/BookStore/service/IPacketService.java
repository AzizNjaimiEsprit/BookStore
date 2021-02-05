package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.Packet;

import java.util.List;

public interface IPacketService {
   List<Object[]> ListerLesBookBypacket();
   List<Packet> getAll();
    String Add(Packet pk);
    String Delete(long id);
   Packet Update(Packet us);
}
