from facialmatch import compare_faces, get_face_from_image
import matplotlib.pyplot as plt

# Compare two images
result = compare_faces("alia.jpeg", "alia2.jpeg")

# Extract face from the first image
face = get_face_from_image("alia.jpeg")  # Ensure the correct file extension

# Display the face using matplotlib
plt.imshow(face)
plt.axis('off')  # Turn off axes for better display
plt.show()

# Print the result of face comparison
print(result)
