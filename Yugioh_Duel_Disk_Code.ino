#include <Stepper.h>

#define STEPS_PER_MOTOR_REVOLUTION 32   
#define STEPS_PER_OUTPUT_REVOLUTION 32 * 64  //2048  

Stepper small_stepper(STEPS_PER_MOTOR_REVOLUTION, 8, 10, 9, 11);

const int SW_pin = 2; // digital pin connected to switch output
const int X_pin = 0; // analog pin connected to X output
const int Y_pin = 1; // analog pin connected to Y output
const int  stepsIn = -60;
const int stepsOut = 60;
int check = 350;

void setup() 
{
  pinMode(SW_pin, INPUT);
  digitalWrite(SW_pin, HIGH);
  small_stepper.setSpeed(1000);
  Serial.begin(9600);
}


void loop() 
{
  while(check <= 500 && check >= 300)
  {
    check = analogRead(X_pin);
  }
  if(check > 500)
  {
    out();
    check = analogRead(X_pin);
  }
  else if (check < 300)
  {
    in();
    check = analogRead(X_pin);
  }
}


void in ()
{Serial.print(check);
  Serial.print("in");
  small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);
  small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);
  small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);
  small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);
  small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);
  small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);small_stepper.step(stepsIn);

  digitalWrite(8,LOW);
  digitalWrite(9,LOW);
  digitalWrite(10,LOW);
  digitalWrite(11,LOW); // releasing the motor
}


void out()
{Serial.print(check);
  Serial.print("out");
  small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);
  small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);
  small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);
  small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);
  small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);
  small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);
  small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);small_stepper.step(stepsOut);

  digitalWrite(8,LOW);
  digitalWrite(9,LOW);
  digitalWrite(10,LOW);
  digitalWrite(11,LOW);  // releasing the motor
}


