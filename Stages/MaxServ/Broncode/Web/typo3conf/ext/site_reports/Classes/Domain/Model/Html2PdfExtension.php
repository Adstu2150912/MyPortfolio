<?php
namespace Html2PdfExtension\Html2Pdf\Extension;

use \Spipu\Html2Pdf\Extension\ExtensionInterface;

/**
 * Class Html2PdfExtension
 */
class Html2PdfExtension implements ExtensionInterface
{
	/**
	 * @var array
	 */
	private $tagDefinitions = array();

	/**
	 * {@inheritDoc}
	 */
	public function getName()
	{
		return 'html2pdf_extension';
	}

	/**
	 * {@inheritDoc}
	 */
	public function getTags()
	{
		if (empty($this->tagDefinitions)) {
			$this->tagDefinitions = array(
				new \ScriptTag\Html2Pdf\Tag\ScriptTag(),
				new \DlTag\Html2Pdf\Tag\DlTag(),
				new \DtTag\Html2Pdf\Tag\DtTag(),
				new \DdTag\Html2Pdf\Tag\DdTag(),
				new \CanvasTag\Html2Pdf\Tag\CanvasTag(),
			);
		}

		return $this->tagDefinitions;
	}
}