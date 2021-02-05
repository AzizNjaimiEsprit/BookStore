package tn.esprit.BookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import tn.esprit.BookStore.model.Packet;
import tn.esprit.BookStore.repository.PacketRepository;
import tn.esprit.BookStore.service.PacketService;


@RequestMapping("/packet")
@RestController
public class PacketController {
	   @Autowired
	   private PacketService packetService;
	   @Autowired
	   private PacketRepository pkr;
	@GetMapping("/GetNbreBookParPacket")
	@ResponseBody
    public List<Object[]> GetAllpacket() {
        return packetService.ListerLesBookBypacket();
    }
    @GetMapping
   	@ResponseBody
       public List<Packet> getAllPackets(){ 
           
    	return   packetService.getAll();
      	  
       } 
    @PostMapping("/Addpacket")
    @ResponseBody
    public String AddPacket(Packet pk) {
    	return packetService.Add(pk);
		 
	}
    @DeleteMapping("/suppPacket/{id}")
    @ResponseBody   
    public String SupprimerPacket( @PathVariable("id") long id) {
    	return packetService.Delete(id); 
	
    }
    //update
    @PutMapping("/modifyPacket")
    @ResponseBody
	   public Packet modifypacket( Packet pk) {
	   return packetService.Update(pk);
	   }


    @GetMapping("/voiceSearch")
    @ResponseBody
    public Packet SearchVoice() {
    	RestTemplate rs=new RestTemplate();
    	String tit=rs.getForObject("http://127.0.0.1:5000/", String.class);
    	return pkr.voiceSearch(tit); 
	
    } 

}
 