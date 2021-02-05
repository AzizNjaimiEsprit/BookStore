package tn.esprit.BookStore.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Packet;

@Repository
public interface PacketRepository extends JpaRepository<Packet,Long > {
	@Query("SELECT ve, Count(v.title) as NbreBook FROM Book v JOIN v.pkt ve GROUP BY ve.titre")
	public List<Object[]> NumberBookGroupedByPacket();
	
	@Query("Delete from Packet p where p.id=:pkt")
	@Modifying
	@Transactional
	public void RemoveAndSetNull(@Param("pkt") Packet x);
	
	@Query("SELECT u FROM Packet u WHERE u.titre= :titre or objectif= :titre")
	public Packet voiceSearch(@Param("titre") String titre);

}
         