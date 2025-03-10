const eye = document.querySelector('.eye');
const pupil = document.getElementById('pupil');

addEventListener('mousemove', movePupil);

function movePupil(event) {
  const eyeRect = eye.getBoundingClientRect();

  const eyeCenterX = eyeRect.left + eyeRect.width / 2;
  const eyeCenterY = eyeRect.top + eyeRect.height / 2;

  const mouseX = event.clientX;
  const mouseY = event.clientY;

  const deltaX = mouseX - eyeCenterX;
  const deltaY = mouseY - eyeCenterY;

  const distance = Math.sqrt(deltaX ** 2 + deltaY ** 2);

  const maxDistance = (eyeRect.width - pupil.offsetWidth) / 2;

  if (distance <= maxDistance) {
    pupil.style.transform = `translate(${deltaX}px, ${deltaY}px)`;
  } else {
    const scale = maxDistance / distance;
    pupil.style.transform = `translate(${deltaX * scale}px, ${deltaY * scale}px)`;
  }
}
