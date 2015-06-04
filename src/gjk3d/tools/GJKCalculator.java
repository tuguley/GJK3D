package gjk3d.tools;

import gjk3d.entities.Shape;
import gjk3d.entities.Vec3D;

import java.util.ArrayList;

public class GJKCalculator {

    /**
     * Using GJK, return whether the shapes s1 and s2 are colliding.
     * 
     * @param s1 the first shape.
     * @param s2 the second shape.
     * @return true if s1 and s2 intersect, false otherwise.
     */
    public boolean isColliding(Shape s1, Shape s2) {

        Vec3D dir = Vec3D.XAXIS;

        Vec3D newPt;

        ArrayList<Vec3D> simplex = new ArrayList<>(4);

        simplex.add(getSupport(s1, s2, dir));
        dir.negate();

        while (true) {

            newPt = getSupport(s1, s2, dir);

            // If the new point in the new direction cannot even make it past
            // the origin, then there is no way to encapsulate the origin.
            if (newPt.dot(dir) < 0) {
                return false;
            }

            else if (computeSimplex(simplex, dir)) {
                return true;
            }

        }

    }

    /**
     * Returns the support point of the minkowski difference of s1 and s2 in
     * direction dir.
     * 
     * @param s1 the first shape.
     * @param s2 the second shape.
     * @param dir the direction to get the support point in.
     * @return the corresponding support mapping of dir for s1 - s2.
     */
    private Vec3D getSupport(Shape s1, Shape s2, Vec3D dir) {
        return Vec3D.sub(s1.support(dir), s2.support(Vec3D.getNegated(dir)));
    }

    /**
     * Modifies the simplex according to it's current characteristics and change
     * the search direction if needed.
     * 
     * @param simplex the simplex computed so far.
     * @param dir the search direction.
     * @return true if the origin is inside the simplex, false otherwise.
     */
    private boolean computeSimplex(ArrayList<Vec3D> simplex, Vec3D dir) {

        switch (simplex.size()) {
            case 2:
                return computeLineSimplex(simplex, dir);
            case 3:
                return computeTriangleSimplex(simplex, dir);
            case 4:
                return computeTetraSimplex(simplex, dir);
            default:
                System.err.println("Simplex size error.");
                System.exit(0);
        }

        return false;
    }

    private boolean computeLineSimplex(ArrayList<Vec3D> simplex, Vec3D dir) {
        // TODO
        return false;
    }

    private boolean computeTriangleSimplex(ArrayList<Vec3D> simplex, Vec3D dir) {
        // TODO
        return false;
    }

    private boolean computeTetraSimplex(ArrayList<Vec3D> simplex, Vec3D dir) {
        // TODO
        return false;
    }

}
