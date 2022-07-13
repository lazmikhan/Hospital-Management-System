import java.util.ArrayList;
import java.util.Scanner;
//Toya Lazmin Khan
public class ClinicApp {
  public static void main(String[] args) {

// TASK 6(i): Modify the array of object implementation below to ArrayList -  [6 marks]
// TASK 6(i): Use the ArrayList medication to store all Medication objects. 
// TASK 6(i): Use the ArrayList  doctorList to store all the Doctor objects.


  	   // Medication [] medication =new Medication [5];
		  ArrayList<Medication> medication= new ArrayList<Medication>();
  	   
		  ArrayList<Doctor> doctorList= new ArrayList<Doctor>();
            Scanner input = new Scanner(System.in);
            int choice, medicNum;
medication.add(new Medication("Aspirin tablet", "Reduce blood clotting\t", 20.00, "1"));
medication.add(new Medication("Allergy shots", "\tImprove immune system\t", 150.50, "2"));
medication.add(new Medication("Antihistamines", "Reduce blood clotting\t", 40.80, "3"))  ;   
medication.add(new Medication("Nasal sprays", "\tEase nasal congestion\t", 70.00, "4"))  ;  
medication.add(new Medication("Calamine lotion", "Relieve itchy skin\t", 25.50, "5"))  ;  
            
doctorList.add(new Doctor("Dr. Arif Izzuddin, M.D, M.S.", 30.0, "Dermatologists", "A-115","N"))  ;
doctorList.add(new Doctor("Dr. Hafiz Hakim, M.D", 25.00, "Infectious diseases", "C-311", "M"))  ;
doctorList.add(new Doctor("Dr. Nuha Faqihah, M.D, M.S", 40.00, "Paediatrician", "B-214","A"))  ;
            



            

            

// End of TASK 6

            String name;
            String hp;
            String add;
            String date = "";
            double time = 0.0;
            int age=0;

            System.out.println("******** KLINIK MESRA ********");
            System.out.print("Enter patient name: ");
            name = input.nextLine();

            System.out.print("Enter patient address : ");
            add = input.nextLine();

            System.out.print("Enter patient phone number: ");
            hp = input.nextLine();

            System.out.print("Enter patient phone age: ");
            age = input.nextInt();

            Consultation app = new Consultation(date, time);

            Patient pt = new Patient(name, add, hp,age, app);

            do {
                System.out.println("\n******** KLINIK MESRA ********");
                System.out.println("1.  Consultation Detail");
                System.out.println("2.  Medication Details");
                System.out.println("3.  Payment Detail");
                System.out.println("4.  Exit");

                System.out.print("\nPlease enter your choice (1-4) : ");
                choice = input.nextInt();
                System.out.println();

                switch (choice) {
					case 1:
					      System.out.println("******** Consultation Detail ********");
					      System.out.println();
				              System.out.print("Enter date (dd/mm/yy): ");
					      date = input.next();
					      System.out.print("Enter time (24hour format):");
					      time = input.nextDouble();
					      System.out.println();

					      app = new Consultation(date, time);
					      pt = new Patient(name, add, hp,age,app);

					      int pick;
					      System.out.println("Doctor Detail:");
					      System.out.println();

// TASK 7(i): Complete the body of 'if statements' below to invoke method display info based on Doctor's availability, invoke methods meetDr() and consutSet() once the condition is met. [6 marks]
					                    
					         if (time > 8.00 && time <= 12.00) {

						//TASK 7(i): methods invocation come here
                       doctorList.get(1).displayDoctor();
					   pt.consultSet(app);
					   pt.meetDr(doctorList.get(1));
                           
					          } else if (time > 12.00 && time <= 18.00) {

						//TASK 7(i): methods invocation come here
						doctorList.get(2).displayDoctor();
						pt.consultSet(app);
						pt.meetDr(doctorList.get(2));

					          } else if (time > 18.00 && time <= 23.00) {
						
						//TASK 7(i): methods invocation come here
						doctorList.get(0).displayDoctor();
						pt.consultSet(app);
						pt.meetDr(doctorList.get(0));
					          }
					         
						 break;

				         case 2:
                        			System.out.println("LIST OF MEDICATION ");
						System.out.println("Medication\t\t\t\tDescription\t\t\tPrice(RM)");
					   	
						for (int i = 0; i < medication.size(); i++) {
					   	    Medication m = medication.get(i);
					   	    System.out.println((i + 1) + "." + m.getMedic() + "\t\t" + m.getDescription() + "\t\t" + m.getPrice());
                        			}
                        			
						String buy;
                     			  	int qty=0;
                        			System.out.print("\n How many type of medicine?: ");
                       				medicNum = input.nextInt();
                        				
						for (int i = 0; i < medicNum; i++) {
                            			
							System.out.println("");
                            				System.out.print("Enter medicine id: ");
                           		        	buy = input.next();
                            				System.out.print("Enter quantity: ");
			    				qty = input.nextInt();

                            				for (Medication medic : medication) {

                                				if (medic.getID().equals(buy)) {
                                    					pt.buyMedication(medic);
                                   					medic.setQty(qty);
                                    					System.out.println("Item : " + medic.getMedic()+ "\t\t Quantity : "+qty);
                                				}
                            				}
                        			}
                        			
						break;

                    			case 3:
                        		       System.out.println("<<<< PAYMENT DETAIL >>>>\n");
                        		       pt.display();
                        		       break;

                    			default:
                                               System.out.println("Thank you for using our system");
                                               break;
                	  }

            } while (choice != 4);
       }
 }


