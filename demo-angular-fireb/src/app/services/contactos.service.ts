import { Injectable } from '@angular/core';
import {addDoc, collection, firestore,getDoc,getDocs} from '@angular/fire/firestore';
@Injectable({
  providedIn: 'root'
})
export class ContactosService {

  constructor(private Firestore: firestore) { }
  addContacto(nombre:string, direccion: string){
    addDoc(collection(this.Firestore, 'contactos'),{'nombre': nombre, 'dirección': direccion})
  }

  async getContactos(){
    const contactosSnapshot = await getDocs(collection(this.firestore, 'contactos'))
    return contactosSnapshot.docs.map(doc => (id: doc.id, ...doc.data))
  }
}
