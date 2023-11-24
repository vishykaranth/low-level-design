package small_apps.framework;

public class Walk implements Move {
    @Override
    public void action() {
//        System.out.println("5 miles per hour - it is slow!");
        System.out.println("Walk");
    }
}


/*

The goal of framework is defining a process which let developers implement certain functions based on individual requirements.
In other words, framework defines the skeleton and developers fill in the flesh when using it.

Main.java is the entry point of the framework. This can not be changed.

Move.java is the Hook. A hook is where developers can define / extend functions based on their own requirements.

Human.java is the Template, which reflects the idea of how the framework works.


This simple framework allows and requires developers to extend "Move" class.
Actually, in this simple framework, action() method is the only thing developers are able to change.

Inside of the implementation, different "action" can be programmed to different purpose.
E.g. the example below print "5 miles per hour", of course, you can redefine it as "50 miles per hour".

The example here just shows how a simple Template and Hook works.
A real framework is more complicated than this.
Not only does it contain other relations like template-temple relation,
but also very complex process about how to efficiently improve performance and programming usability.



 */