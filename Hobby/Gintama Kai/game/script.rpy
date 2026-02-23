## The script of the game goes in this file.
 
#init:
#    $ left = Position(xpos=0.0, xanchor='left')
#    $ center = Position(xpos=0.5, xanchor='center')
 #   $ right = Position(xpos=1.0, xanchor='right')

 #   $ top = Position(xpos=0.5, xanchor='center', ypos=0.0,
          #         yanchor='top')
# Transform declarations
transform midleft:
  xpos 0.4
transform midright:
  xpos 0.6
transform left:
    xpos -0.25
transform right:
    xpos 0.25

init:
    $ AP = 0; # Affinity points (used to gauge the players 'karma' with the characters in-game as the story progress)

# A character that pulls its name from a variable.
define player = Character("player_name", dynamic=True)


define Gintoki = Character('Gintoki Sakata', image="Gintoki", color="#c8ffc8")

define Kagura = Character('Kagura', image="Kagura", color="#c8ffc8")

define Shinpachi = Character('Shinpachi Shimura', image="Shinpachi", color="#c8c8ff")

define ToyakoSennin = Character('Lake Toya Spirit', image="Toyako Sennin", color="#007FFF")

define ToyakoMom = Character("Lake Toya Spirit's Mom", image="Toyako Mom", color="#FF0055")

define ToyakoDad = Character("Lake Toya Spirit's Dad", image="Toyako Dad", color="#857549")

define Katsura = Character("Kotarō Katsura", image="DJ Ozura", color="#55AAFF")

define Hasegawa = Character("Taizō Hasegawa", image="Hasegawa", color="#857549")

image Elizabeth = "char/Elizabeth (idle).png"
image ElizabethJoui_is = "char/Elizabeth (Joui is).png"
image ElizabethJoui_is_JOY = "char/Elizabeth (Joui is JOY!).png"
 
image bg odd jobs house = "bg/Odd Jobs House.jpg"
image bg kuro = "bg/Kuro.png"
image bg shiro = "bg/Shiro.png"
image bg edo = "bg/Edo full cover.png"
image bg internal odd jobs house = "bg/Odd Jobs house inside.jpg"
image bg odd jobs otose snack = "bg/Odd Jobs and Otose Snack.jpg"
image black = "#000"


## image movie = Movie(size=800,600),xpos=100,ypos=50,xanchor=50,yanchor=100)
init:
    image movie = Movie()

label start:
    scene bg internal odd jobs house
    with Dissolve(.5)
    play music "music/04 - Toubun Tora ne Tonaa.mp3"  fadein 1.0
    "What would you like to do?"
    menu:
        "Try demo":
             stop music fadeout 1.0
             jump openingscreen 
        "Let's play the game!":
             stop music fadeout 1.0
             jump game
        "Return to Main Menu":
             stop music fadeout 1.0
             return
        ##"Are you sure you want to leave?"
        ##menu:
            ## "Yes, I quit.":
               ##  stop music fadeout 1.0
                 ##return
           ##  "No, I want to play more!":
             ##    jump start

label openingscreen:
    scene black
    with Pause(1)
    
    play music "music/31 - Banji Ya Gin Chan to wa Ore Tachi no Koto da!.mp3"  fadein 1.0
    show text "After many years..." with dissolve
    with Pause(2)
    
    hide text with dissolve
    with Pause(1)
    
    show text "This is what you've finally been waiting for" with dissolve
    with Pause(2)
    
    hide text with dissolve
    with Pause(1)
    
    show text "The Gintama Video Game Production Committee presents" with dissolve
    with Pause(2)
    
    hide text with dissolve
    with Pause(1)
    
    stop music fadeout 1.0
    
    $ renpy.movie_cutscene("Gintama Kai - Intro.mkv")
    
    jump prologue_campaign
        
label prologue_campaign:
   
    scene bg shiro
    with fade
    play music "music/Gintama OST - 35 - Ore mo, Mou Jump Sotsugyou Shi Nakya Ike nee Toshi da yo naa.mp3" fadein 1
    pause 3
    "..."
    show Shinpachi (idle)
    with dissolve
    Shinpachi "Uhm, excuse me…where are we?" (multiple=2)
    Shinpachi "And what are we supposed to do?" (multiple=2)
    hide Shinpachi (idle)
    with dissolve
    show Gintoki (idle)
    with dissolve
    Gintoki "Isn’t that obvious? Gintama needs its own new video game, that’s why we are here."
    hide Gintoki (idle)
    with dissolve
    show Kagura (idle)
    with dissolve
    Kagura "Exactly, after all this time I thought Bandai Namco and the game industry have given up on us."
    hide Kagura (idle)
    with dissolve
    show Gintoki (idle)
    with dissolve
    Gintoki "After the anime ended for the 3th time, Gintama lost its novelty."
    Gintoki "In order to make Gintama great again, it has been decided to make visual novel game."
    hide Gintoki (idle)
    with dissolve
    show Kagura (idle)
    with dissolve
    Kagura "A game, that’s surprising!"
    Kagura "I’m really excited!"
    hide Kagura (idle)
    with dissolve
    show Shinpachi (Angry)
    with dissolve
    with vpunch
    Shinpachi "Waaiiit!"
    Shinpachi "Why so suddenly a video game, this can’t be true!"
    hide Shinpachi (Angry)
    with dissolve
    show Gintoki (idle)
    with dissolve
    Gintoki "It IS true, look over there! As of right now, this game is being played in front of us by this person!"
    hide Gintoki (idle)
    with dissolve
    show Kagura (idle)
    with dissolve
    Kagura "Wow, that person in front of us has too much free time."
    Kagura "Why would someone bother picking up the anime Gintama, let alone this game." 
    hide Kagura (idle)
    with dissolve
    show Shinpachi (Angry)
    with dissolve
    Shinpachi "Don’t talk like that!!"
    Shinpachi "Pay some respect, we don’t have time for any joke."
    Shinpachi "Remember, this is our chance to shine! So, let’s wrap it this up already."
    hide Shinpachi (Angry)
    with dissolve 
    stop music fadeout 1
    
    scene bg odd jobs house
    with fade
    play music "music/Gintama OST 2 - 28 Nani Shiten no Kono Nin Tachi.mp3" fadein 1.0
    show Gintoki (idle)
    with dissolve
    Gintoki "Upsie Daisy, let’s start this game!"
    hide Gintoki (idle)
    with dissolve
    show Shinpachi (Angry)
    with dissolve
    Shinpachi "HOLD ON, why are we using the same background from the anime over and over again?!"
    hide Shinpachi (Angry)
    with dissolve
    show Kagura (idle)
    with dissolve
    Kagura "The budget and time for making this game is tight, so have to sacrifice something."
    hide Kagura (idle)
    with dissolve
    show Gintoki (idle)
    with dissolve 
    Gintoki "That’s right, there’s that and why bother? This game won’t get THAT much attention anyway…"
    hide Gintoki (idle)
    with dissolve
    show Shinpachi (Angry)
    with dissolve
    Shinpachi "That’s not true! Money and time must not be an issue anymore!"
    hide Shinpachi (Angry)
    with dissolve
    show Kagura (idle)
    with dissolve
    Kagura "I agree, this game is made by \"Adam Oubelkas\" So we don’t have to worry much."
    hide Kagura (idle)
    with dissolve
    show Shinpachi (idle)
    with dissolve
    Shinpachi "Don’t give up just yet, we have to try our best!"
    hide Shinpachi (idle)
    with dissolve
    show Gintoki (idle)
    with dissolve
    Gintoki "JUST DO IT!"
    ## hide Gintoki
    ## with dissolve
    stop music fadeout 1
    hide bg shiro
    ## behind Gintoki
    show movie at Position(xpos=520, ypos=64, xanchor='left', yanchor='top')
    $ renpy.movie_start_displayable('zeldaOP.mkv', (640, 480))
    "Test...1"
    $ renpy.movie_stop()
    hide movie
    menu:
        
         "Yes, I do.":
             jump choice1_yes
         "No, I don't.":
             jump choice1_no  
                
    label choice1_yes: 
       
         $ menu_flag = True
       
         Shinpachi "Arigato gozaimasu!"
       
         jump choice1_done
    
    label choice1_no: 
       
         $ menu_flag = False
       
         Shinpachi "DONDAKE!!!"  
       
         jump choice1_done  
         
    
    label choice1_done:
       
         "...Just do it! FIN"
         return
             
label game:
   jump chapter0
   label chapter0:
       scene black
       with Pause(1)
        
       play music "music/31 - Banji Ya Gin Chan to wa Ore Tachi no Koto da!.mp3" fadein 1
        
       show text "After many years..." with dissolve
       with Pause(2)
        
       hide text with dissolve
       with Pause(1)
        
       show text "This is what you've finally been waiting for" with dissolve
       with Pause(2)
        
       hide text with dissolve
       with Pause(1)
        
       show text "The Gintama Video Game Production Committee presents" with dissolve
       with Pause(2)
        
       hide text with dissolve
       with Pause(1)
        
       stop music fadeout 1.0
        
       $ renpy.movie_cutscene("Gintama Kai - Intro.mkv")
       scene black
       with fade
       show text "Gintama the Visual Novel" at truecenter
       with dissolve
       pause 2
       hide text
       with dissolve
       show text "Chapter 0 \n How to start a Visual Novel?!" at truecenter
       with dissolve
       pause 2
       hide text
       with dissolve
       play music "music/08 - Chi ni Ueta Kyouken.mp3" fadein 1
       Guest "Wake up."
       Guest "The time has finally come..."
       Guest "For you to awaken your hidden power."
       Guest "Open…your eyes…to the gateway of your true potential…"
       Guest "Wake up."
       show Gintoki at left
       with dissolve 
       Gintoki "Huh? Where are we?"
       show Shinpachi at center
       with dissolve
       Shinpachi "Good morning."
       Shinpachi "What's this? Where are we?"
       Gintoki "\"What’s this\"? I don’t know."
       Gintoki "When I woke up this morning, I was in this place."
       show Kagura at right
       with dissolve
       Kagura "Is there a power outage, uh-huh?"
       Gintoki "Shut up!"
       Gintoki "I have a hangover, you know."
       Gintoki "I’m going back to sleep."
       hide Gintoki
       with dissolve
       Gintoki "Shinpachi, run a bath for me."
       Shinpachi "There’s no bath here, Gin-san!"
       hide Kagura
       with dissolve
       Kagura "Make breakfast, Shinpachi."
       Shinpachi "It’s your turn to cook, Kagura!" with vpunch
       hide Shinpachi
       with dissolve
       Shinpachi "Whatever!"
       Shinpachi "I wonder if this is all a dream…"
       Shinpachi "I’m going back to sleep too."
       Guest "Wake up…"
       Guest "Your hidden power…"
       Guest "The time to awaken it has finally come."
       Gintoki "Shut up. Who set this weird alarm?"
       Guest "This is the time to wake up." 
       Kagura "It’s only eight in the morning!"
       Kagura "Let me sleep two more hours at least, you idiot."
       stop music fadeout 1.0
       Guest "No, well…I'm not an alarm…"
       Guest "Ahem…would you please listen to me?"
       Guest "Um…Well, wake up!"
       Guest "Excuse me, please wake up!"
       Guest "Excuse me, please listen!"
       Guest "Hello!"
       Guest "Everyone!"
       show Angry Toyako Sennin at center
       with dissolve and hpunch
       Guest "I SAID WAKE UP ALREADY!!!!"
       Guest "THAT IS ENOUGH!!! CUT IT OUT!!!"
       Guest "How could you fall back to sleep in another world?!"
       Guest "Think about it! Isn’t there something unusual about this place?!"
       hide Angry Toyako Sennin with dissolve
       Shinpachi "Gin-san!"
       Shinpachi "Gin-san, please wake up!" 
       Gintoki "What? Why all the noise?"
       Shinpachi "There’s a strange man…"
       show Lake Toya Sennin with dissolve
       play music "music/11 - Uchuu Ichi Baka na Samurai da Kono Yaroo!!.mp3" fadein 1
       Guest "Ahem…"
       Guest "You finally woke up."
       Guest "Welcome to my world."
       Guest "Finally, the time for you to awaken has arrived."
       Gintoki "Huh?"
       Gintoki "Who are you?"
       Guest "Don’t you know, Gintoki?"
       Guest "I’m always with you."
       Guest "I’m your blade, which you’ve used to overcome many hardships!"
       Guest "My name is…"
       Guest "Lake Toya!"
       Gintoki "The spirit of Lake Toya?"
       ToyakoSennin "You may call me that."
       ToyakoSennin "Gintoki, as I am the closest to you, I know…"
       ToyakoSennin "…that you’re strong…"
       ToyakoSennin "No one in history has been able to use me like you do."
       ToyakoSennin "But…but…"
       ToyakoSennin "It’s still not enough!"
       ToyakoSennin "You’ve still much more to learn!"
       ToyakoSennin "You can still become stronger!"
       ToyakoSennin "You haven’t topped my full power yet!"
       ToyakoSennin "Do you want to get stronger, Gintoki?"
       menu:
           "Yes, let's get started!":
               jump demo_techniques
           "I pass.":
               jump refuse_toyakosennin
       label refuse_toyakosennin:
           stop music fadeout 0.5
           Gintoki "No, I’m not interested."
           ToyakoSennin "…Huh?"
           ToyakoSennin "Eh?!"
           ToyakoSennin "What?!"
           ToyakoSennin "What did you just say?!"
           play music "music/35 - Ore mo, Mou Jump Sotsugyou Shi Nakya Ike nee Toshi da yo naa.mp3" fadein 0.7
           Gintoki "Damn, you’re so annoying."
           Gintoki "Look, I have a bad headache, so leave me alone, okay?"
           ToyakoSennin "Huh? No, but… What?"
           ToyakoSennin "This {b}{i}Visual Novel{/i}{/b} has only just begun…"
           ToyakoSennin "You were supposed to accept my offer and get motivated."
           ToyakoSennin "You need to acquire atleast some new deadly techniques now. Wouldn’t that be nice?"
           ToyakoSennin "If I do say so myself, it’s really useful."
           ToyakoSennin "Let me teach it to you."
           Shinpachi "Excuse me, but it’s our day off."
           Shinpachi "Can we go home now?"
           ToyakoSennin "No…well…it’s far more useful than you think."
           ToyakoSennin "If you learn it, you’ll be able to use it repeatedly."
           ToyakoSennin "And, most of all, you’ll easily be able to make a big scene..."
           Kagura "Shut up, you old windbag!"
           Kagura "Just return us to our world right now!"
           ToyakoSennin "I see…"
           ToyakoSennin "Well, it’s fine with me if you don’t want to…"
           ToyakoSennin "Really…it’s not like I was asked to do it, anyway…"
           ToyakoSennin "Well…I just called you on my own…"
           ToyakoSennin "I’m sorry for wasting your time…"
           ToyakoSennin "But let me just tell you…"
           ToyakoSennin "It’s now or never."
           ToyakoSennin "This is a one time offer."
           ToyakoSennin "It’s really too bad."
           ToyakoSennin "It’s a shame to miss out."
           ToyakoSennin "What a waste."
           ToyakoSennin "Bankai or Kamehameha is really useful…"
           ToyakoSennin "…you know…"
           ToyakoSennin "…"
           menu:
               "Fine, teach us some techniques":
                   jump demo_techniques
               "Leave us alone!":
                   jump ignoring_toyakosennin
       label ignoring_toyakosennin:
           ToyakoSennin "Just say \”please teach it to us\”!"
           ToyakoSennin "You don’t want deadly techniques, eh?"
           ToyakoSennin "Are you really that lazy?!"
           ToyakoSennin "Why are you ignoring a spirit for the third time?!"
           ToyakoSennin "Even on your day off, you hardly ever refuses three times!"
           ToyakoSennin "Hey! Wake up, you guys! Come on!"
           ToyakoSennin "If you don’t wake up in the next three seconds, I’ll give a {b}Whack{b} kick right in the thigh!"
           ToyakoSennin "I’m serious!"
           ToyakoSennin "I’ll really do it!"
           ToyakoSennin "You won’t be able to walk!"
           ToyakoSennin "Here we go!"
           menu:
               "Kick his ass right now!":
                   jump staying_hostile
               "Just wait a bit":
                   jump just_waiting
           label just_waiting:
               ToyakoSennin "One…"
               ToyakoSennin "The countdown to hell has begun!"
               ToyakoSennin "Ah, it’s so scary!"
               ToyakoSennin "And two!"
               ToyakoSennin "Ah, there’s only one second left!"
               ToyakoSennin "I’m counting!"
               ToyakoSennin "Really!"
               menu:
                   "Just kick his ass alright!":
                       jump staying_hostile
                   "Keep waiting":
                       jump keep_waiting
           label keep_waiting:
               ToyakoSennin "And three!"
               ToyakoSennin "I’m finished counting!"
               ToyakoSennin "It’s all over!"
               ToyakoSennin "Want more time?!"
               ToyakoSennin "Alright!"
               ToyakoSennin "Let me give you five more seconds!"
               jump staying_hostile
       label staying_hostile:
           show Angry Gintoki at left with vpunch
           show Angry Kagura at right with hpunch
           "Gintoki & Kagura"  "SHUT UP!!!"
           "{b}*Both kicking in the thighs of Lake Toya Spirit*{/b}"
           ToyakoSennin "AGH!"
           hide Lake Toya Sennin with dissolve
           hide Angry Gintoki with dissolve
           hide Angry Kagura with dissolve
           show Angry Gintoki at left with dissolve           
           Gintoki "What do you want from us?"
           Gintoki "Tell us straight…exactly what are you trying to do?"
           show Smug Toyako Sennin at right
           ToyakoSennin "I’ll tell it to you straight."
           ToyakoSennin "You’re not too bad if you can hurt a spirit’s legs…"
           ToyakoSennin "But you’re still too green."
           ToyakoSennin "You can be even stronger."
           menu:
               "Keep listening":
                   jump keep_listening
               "Show no interest and keep refusing Lake Toya Spirit’s offer":
                   jump demo_techniques
               
           label keep_listening:
               hide Gintoki with dissolve
               show Shinpachi Expression 1 at center with dissolve
               Shinpachi "I’ll tell it to you straight…" 
               Shinpachi "We’re strong enough to make a spirit’s eyes tear up, so that’s enough for us."
               ToyakoSennin "Why are you so stubborn?"
               ToyakoSennin "Why would you refuse to learn the deadly techniques?"
               ToyakoSennin "Are you just shy?"
               ToyakoSennin "Or are you ashamed?"
               ToyakoSennin "Are you embarrassed to shout out the names of the deadly techniques?"
               ToyakoSennin "Well?"
               ToyakoSennin "But everyone needs to have patience when learning it."
               ToyakoSennin "The important thing is getting used to using it."
               show Angry Kagura at left with dissolve
               Kagura "Why is he so insistent?"
               ToyakoSennin "If there is to be made a fighting game about Gintama, it’ll be too plain if it doesn’t have deadly techniques."
               ToyakoSennin "Think about it from a business perspective."
               ToyakoSennin "The company that develops it. Do you want them to give up?"
               ToyakoSennin "Don’t you know how hard a time Bandai Namco’s had?"
               Shinpachi "You worry about things beyond your control!"
               hide Angry Kagura with dissolve
               jump demo_techniques
       label demo_techniques:                     
           Shinpachi "Let us go home already."
           ToyakoSennin "No, in fact, I'll force you all to stay here until you gain something interesting to use!"
           ToyakoSennin "Unless you become stronger, you'll never leave this place! "
           stop music fadeout 0.3 
           play music "music/11 - Dorobou wa Dorobou Demo Koi Dorobou sa!!.mp3" fadein 0.5
           hide Lake Toya Sennin with dissolve
           show Gintoki with dissolve
           Gintoki "Ah, that's fine."
           show Shinpachi at right with dissolve
           Shinpachi "First let's switch the light on here."
           scene bg shiro with fade
           show Kagura at center with dissolve
           Kagura "We'll stay here for a while."
           hide Kagura with dissolve
           show Disappointed Toyako Sennin at right with dissolve
           ToyakoSennin "Well...it's not like \"a while,\"but forever..."
           Guest "It's no use, Lake Toya Spirit."
           ToyakoSennin "Stay out of this!"
           ToyakoSennin "It’s none of your business, mom!"
           show Toyako Sennin Mom with dissolve
           Shinpachi "Somehow…the mother appeared…the mother of Lake Toya Spirit…"
           hide Disappointed Toyako Sennin with dissolve
           ToyakoMom "If you still don’t want to learn the deadly techniques, I have an idea."                     
           ToyakoMom "Not long ago have I recruited a few pupils, and they already have mastered some deadly techniques!"
           Gintoki "Why does his mom have a beard?"
           ToyakoMom "Let me introduce you to my pupils."
           menu:
               "Keep watching":
                   jump keep_watching_ToyakoMom
               "Ignore and skip this":
                   jump ToyakoDad_Approach
       label keep_watching_ToyakoMom:
           hide Toyako Sennin Mom with dissolve
           Guest "That’s not right. Didn’t I just teach you?"
           Guest "Let’s try that again."
           stop music fadeout 0.3
           show DJ Ozura at right with dissolve
           Guest "Ready…" 
           play sound "sound/Gintama - Katsura's rap[Part I].mp3"
           show Elizabeth at left with dissolve 
           play sound "sound/Gintama - Katsura's rap[Part II].mp3"
           Guest "If you’re going to do it, do it now, Zura." (multiple=2)
           Guest "If you're going to do it, do it now, Zura." (multiple=2)
           Guest "Joui is Joy! Joui is Joy!"
           Guest "Now repeat after me!"
           hide Elizabeth with dissolve
           show ElizabethJoui_is at left with dissolve:
               xpos -0.12
           hide ElizabethJoui_is with dissolve
           show ElizabethJoui_is_JOY at left with dissolve:
               xpos -0.12
           Guest "…"
           play sound "sound/Gintama - Katsura's rap[Part III].mp3"
           Guest "No! Speak out!"
           play sound "sound/Gintama - Katsura's rap[Part IV].mp3"
           Guest "Don’t use the sign!"
           hide ElizabethJoui_is_JOY with dissolve
           show Elizabeth at left with dissolve
           play sound "sound/Gintama - Katsura's rap[Part V].mp3"
           Guest "I know you speak perfectly when I’m not around!"
           play sound "sound/Gintama - Katsura's rap[Part VI].mp3"
           Guest "Okay, one more time."
           Guest "Okay…Joui is…!"(multiple=2)
           Gintoki "JOY!" (multiple=2) 
           play sound "sound/Gintama - Katsura's rap[Part VII].mp3" 
           show Angry Gintoki at center with dissolve and vpunch
           
           Guest "Oh."
           Gintoki "Don’t \”oh.\” me. What are you doing here, Zura?"
           play music "music/23 - Dura Janai Katsura daaa!!.mp3" fadein 0.4
           Katsura "It’s Katsura, not Zura!!" 
           Katsura "I was trying to promote the Anti-Foreigner Faction via rap, right Elizabeth?"
           "Elizabeth" "!!!"
           Gintoki "Shut up! That isn’t even a useful technique, but it is rather annoying!!"
           hide Angry Gintoki with dissolve
           show Toyako Sennin Mom with dissolve
           ToyakoMom "Sure, it has its shortcomings."
           ToyakoMom "But I’m confident that one day it’ll eventually be powerful enough to pierce the very heavens itself!"
           ToyakoMom "How about I show you some other technique?"
           stop music fadeout 0.8
           ToyakoMom "It is your turn now, Hasegawa!"
           hide DJ Ozura with dissolve
           hide Elizabeth with dissolve
           hide Toyako Sennin Mom with dissolve
           show Hasegawa-san with dissolve
           play music "music/Dragonball Z - Super Saiyan 3 Ascension Theme.mp3" fadein 0.3
           Hasegawa "You're going to love this, trust me."
           Hasegawa "What you're seeing now is my normal state!"
           hide Hasegawa-san with dissolve
           show Super MADAO with dissolve:
               xalign 1.0
           Hasegawa "This is what is known as a {i}MADAO{/i} that has ascended past a {i}MADAO{/i}!"
           stop music fadeout 0.7
           play music "music/28 - Nani Shiten no Kono Nin Tachi.mp3" fadein 0.5
           Hasegawa "Or you can just call this a {b}Super{/b} {i}MADAO{/i}!"
           Shinpachi "What is this?! Why?!"
           show Toyako Sennin Mom at right with dissolve             
           ToyakoMom "Hasegawa has unlocked a hidden power which makes him twice as stronger."
           Shinpachi "But this is actually not a technique…"
           Shinpachi "But rather, a transformation?!"
           Hasegawa "Before, I was just an ordinary Middle-Aged Dumb-Ass Oldie, in short a MADAO (a BUM)."
           Hasegawa "But, by having been through some intense anger, pain and sadness, I have become a Super MADAO (still a bum)."
           Shinpachi "A Super MADAO?!"
           Shinpachi "That is supposed to be impressive?!"
           Shinpachi "In which way and situation is that be useful?"
           Katsura "I understand."
           Gintoki "Which part of that do you even understand?!"
           Katsura "After witnessing the death of his dear friends…"
           Katsura "Grillin, Pickle, Tenshindon and Begeta"
           Katsura "He had to surpass his very own limits, his own weakness, he had to overcome it!"
           Shinpachi "That simply doesn’t make any sense!"
           Hasegawa "Don’t you worry, this is just the beginning!"
           Gintoki "No! Just stop this already!"
           ToyakoMom "Now, do you want to become stronger?"
           Gintoki "What do you mean {i}stronger{/i}?"
           Gintoki "He just changed his appearance! {i}That's all!{/i}!"
           show Yelling Toyako Sennin at left with dissolve
           ToyakoSennin "First impressions are important when introducing new techniques!"
           Gintoki "That doesn’t make anyone stronger!"
           ToyakoSennin "But it does in profit and popularity!"
           ToyakoSennin "It brings back sponsors and supporters alike."
           Shinpachi "No it doesn’t! You only make things worse if you keep this going!"
           Gintoki "Besides, what happened to the deadly techniques you were supposed to teach us?!"
           hide Super MADAO with dissolve
           hide Toyako Sennin Mom with dissolve
           hide Yelling Toyako Sennin with dissolve
           jump ToyakoDad_Approach
       label ToyakoDad_Approach:
           Guest "I suppose it’s time to approach something new and fresh!"
           ToyakoSennin "Dad?!"
           show Toyako Sennin Dad with dissolve
           Shinpachi "What is his Dad doing here?!"         
           ToyakoDad "Listen carefully, what this {i}Visual Novel{/i} needs is a goal for the player to achieve! "
           ToyakoDad "To make this game at least appealing, the player must have something fun to do."
           ToyakoDad "That’s what I’m trying to say!"
           Kagura "So in other words, you have to keep the player busy with a lot dialogue like we’re doing now, right?"
           show Shinpachi Expression 1 at left with dissolve
           Shinpachi "Actually, I think what’s really odd is us characters in this game talking about it."
           Shinpachi "But we have always done things like that in the past anyway."
           show Gintoki at right with dissolve
           Gintoki "No, uh, I don’t care about this {i}Visual Novel{/i} being appealing or whatever."
           hide Toyako Sennin Dad with dissolve
           Gintoki "What matters is the kind of profit, especially sales, we can make of this."
           Gintoki "Whenever someone tries to make and sell a game of us,"
           Gintoki "When the sales started to slow down, it’s already game over for us as well as this game."
           hide Shinpachi Expression 1 with dissolve
           show Angry Shinpachi at left with dissolve
           Shinpachi "Quit saying such obnoxious things!"
           Shinpachi "There’ll {i}never{/i} be a game for us {i}ever{/i} again!!"
           Gintoki "There are a lot of young boys among the other protagonists of popular series."
           Gintoki "But I’m going to say something."
           Gintoki "As an adult protagonist, I’m going to make sure I say that what’s not good is not good."
           hide Angry Shinpachi with dissolve
           show Shinpachi Expression 1 at left with dissolve
           Shinpachi "But you’re the worst one of all!"
           Shinpachi "I’ve never heard of a protagonist that’s such a pain in the ass that he comments on product development!!"
           Gintoki "I’m saying we can’t just be indifferent and leave everything as it is now."
           Gintoki "In the upcoming age, we’re going to have to be the kind of protagonists that manage their own merchandise or it’s all going to shit."
           show Kagura at center with dissolve
           Kagura "Let the player decide it, what do YOU think?"
           menu:
               "Yes, let’s change this game!":
                   stop music fadeout 0.5
                   show Kagura at center with dissolve:
                       alpha 0.5
                   show Shinpachi Expression 1 at left with dissolve:
                       alpha 0.5
                   show Gintoki at right with dissolve:
                       alpha 0.5
                   play music "music/14 - Gohan wa 20 Kai Kan dekara Nomikomi nasai, Wakatta.mp3" fadein 0.5
                   show text "{size=+25}{color=#000000}- To be continued!{/color}{/size}" at truecenter
                   pause(7)
                   hide text with dissolve
               "Leave it as is, just follow the main story":
                   stop music fadeout 0.5
                   show Kagura at center with dissolve:
                       alpha 0.5
                   show Shinpachi Expression 1 at left with dissolve:
                       alpha 0.5
                   show Gintoki at right with dissolve:
                       alpha 0.5
                   play music "music/21 - Eyecatch Desuzee.mp3" fadein 0.5
                   show text "{size=+25}{color=#000000}~ Stay tuned! ~ \n ~ Coming soon! ~{/color}{/size}" at truecenter
                   pause(7)
                   hide text with dissolve
       stop music fadeout 1.0
       show text "{size=+15}{color=#000000}FIN \n The End \n\n Thanks for playing!{/color}{/size}" at truecenter
       pause(5)
       return
